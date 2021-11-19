/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.java8.stream;

import net.qutoutiao.java8.day01.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤：
 * <p>
 * 1、创建Stream
 * <p>
 * 2、中间操作
 * <p>
 * 3、终止操作（终端操作）
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-17 22:59
 * @since 1.2.0, 2019-05-17 22:59
 */
public class TestStreamAPI1 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 9999.99),
            new Employee("王五", 59, 9999.99),
            new Employee("赵六", 20, 33333),
            new Employee("田七", 18, 111)
    );

    //创建Stream
    public void test1() {
        //1、可以通过Collection  系列集合提供的stream() 或者 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2、通过Arrays 中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3、通过Stream 类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //4、创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
    }


    //==========中间操作:多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！而在终止操作时一次性全部处理，成为惰性求值。=========/

    /**
     * 中间操作一：
     * 筛选与切片
     * filter
     * limit
     * skip(n)-跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流。与limit(n)互补
     * distinct-筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     */
    //内部迭代：迭代操作由streamAPI完成
    public void test2() {
        //中间操作：不会执行任何操作
        Stream<Employee> stream = employees.stream()
                .filter((e) -> {
                    System.out.println(e);
                    return e.getAge() > 35;
                });
        //终止操作：一次性执行全部内容，即"惰性求值"
        stream.forEach(System.out::println);
    }

    //外部迭代
    public void test3() {
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * 中间操作二：
     * 映射：
     * Map - 接收Lambda，将元素转换成其他形式或提取信息。接收一个函数，该函数会应用到每个元素上，并将其映射成一个新的元素。
     * FlatMap - 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成另一个流(即：将流中的流打平) 类似：add(Object obj)   addAll(Collection coll)
     */
    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);

        System.out.println("-----------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("-----------");

        Stream<Stream<Character>> streamStream = list.stream()
                .map(TestStreamAPI1::filterCharacter);   //{{a,a,a},{b,b,b},{c,c,c}}
        streamStream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });
        System.out.println("------flatmap-----");
        Stream<Character> characterStream = list.stream()
                .flatMap(TestStreamAPI1::filterCharacter);//{a,a,a,b,b,b,c,c,c}
        characterStream.forEach(System.out::println);


        list.stream()
                .flatMap(TestStreamAPI1::filterCharacter)
                .forEach(System.out::println);

    }

    public static Stream<Character> filterCharacter(String str) {  //add(Object obj)   addAll(Collection coll)
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }


    /**
     * 中间操作三：
     * 排序：
     * sorted()-自然排序（Comparable）即：有些对象自己实现了排序接口例如String
     * sorted(Comparator com)-定制排序（Comparator）对象没有自己排序，需要我们自己传递参数去实现排序
     * <p>
     * 拓展：Comparator与Comparable的区别？？？？？
     */
    public void test6() {
        List<String> list = Arrays.asList("gggg", "ddd", "aaa", "bbb", "ccc");

        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("-----------");
        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge().equals(e2.getAge())) {
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return Integer.compare(e1.getAge(), e2.getAge());
                    }
                }).forEach(System.out::println);

    }


    //=============终止操作===================//

    /**
     * 查找与匹配
     * allMatch-检查是否匹配所有元素
     * anyMatch-检查是否至少匹配一个元素
     * noneMatch-检查是否没有匹配所有元素
     * findFirst-返回第一个元素
     * findAny-返回当前流中的任意元素
     * count-返回流中元素的总个数
     * max
     * min
     */
    public void test7() {
        boolean b1 = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        Optional<Employee> first = employees.stream()
                .sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(first.get());

        System.out.println("-----------");

        long count = employees.stream()
                .count();
        Optional<Employee> max = employees.stream()
                .max((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary()));

        employees.stream()
                .map(Employee::getSalary)
                .min((e1, e2) -> e1.compareTo(e2));
    }

    /**
     * 归约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) -可以将流中元素反复结合起来，得到一个值
     */
    public void test8() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);//有起始值，所以返回不是optional
        System.out.println(sum);

        Optional<Double> op = employees.stream()//没有起始值，所以返回是optional
                .map(Employee::getSalary)
                .reduce(Double::sum);
    }

    /**
     * 收集：
     * collect - 将流转换为其他形式，接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     * Collector接口中方法的实现决定了如何对流执行收集操作（如收集List、Set、Map）。但是Collectors实用类提供了很多静态方法，可以方便地创建常见收集器实例。
     */
    public void test9() {
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);


        System.out.println("-----------");

        HashSet<String> hashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(hashSet);


        //总数
        Long aLong = employees.stream()
                .collect(Collectors.counting());
        System.out.println(aLong);

        //平均值
        Double aDouble = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(aDouble);

        //总和
        Double collect = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect);

        //最大
        Optional<Employee> max = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        //最小
        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());


        //分组
        Map<Employee.Status, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        map.forEach((k, v) -> {
        });
        System.out.println(map);

        Map<Double, Map<String, List<Employee>>> map1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.groupingBy((e) -> {
                    if (((Employee) e).getAge() > 35) {
                        return "青年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(map1);

        //分区
        Map<Boolean, List<Employee>> collect1 = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 3000));

        DoubleSummaryStatistics collect3 = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        collect3.getAverage();

        String collect2 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining());
        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));

        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "--", "=="));

    }

}
