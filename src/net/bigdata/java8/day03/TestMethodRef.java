/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.java8.day03;

import net.bigdata.java8.day01.Employee;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 * （可以理解为方法引用式Lambda表达式的另外一种表现形式）
 * <p>
 * 主要有三种语法格式：
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 * <p>
 * 注意：
 * 1、lambda体中的方法的参数列表和返回值类型要与函数式接口中抽象方法的参数列表和返回值类型一致
 * 2、若Lambda参数列表中的第一个参数是 实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 * <p>
 * 二、构造器引用
 * 格式：ClassName::new
 * 调用那个构造器参数列表y要与函数式接口中方法的参数保持一直
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-17 00:57
 * @since 1.2.0, 2019-05-17 00:57
 * <p>
 * 三、数组引用：Type::new
 */
public class TestMethodRef {

    //数组引用
    public void test7() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] apply = fun.apply(10);
        System.out.println(apply);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] apply1 = fun2.apply(20);
        System.out.println(apply1);
    }


    //构造器引用
    public void test5() {
        Supplier<Employee> up = () -> new Employee();
        //构造器引用方式
        Supplier<Employee> sup2 = Employee::new;
        Employee employee = sup2.get();
        System.out.println(employee);
    }


    public void test6() {
        Function<Integer, Employee> fun = (x) -> new Employee();
        Function<Integer, Employee> fun2 = Employee::new;
        fun2.apply(101);
    }


    //类::静态方法名
    public void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com2 = Integer::compare;

    }

    //类::实例方法名
    public void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> bp2 = String::equals;

    }

    //对象::实例方法名
    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);

        PrintStream out = System.out;
        Consumer<String> con2 = out::println;
        con2.accept("dfdfsdf");
    }

    public void test2() {
        Employee employee = new Employee();
        Supplier<String> sup = () -> employee.getName();
        Supplier<String> sup2 = employee::getName;

        String s = sup.get();
        System.out.println(s);
    }


}
