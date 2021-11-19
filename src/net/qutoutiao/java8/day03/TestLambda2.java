/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.java8.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 内置的四大核心函数式接口
 * <p>
 * Consumer<T>:消费型接口
 * void accept(T t)
 * <p>
 * Supplier<T>:供给型接口
 * T get()
 * <p>
 * Function<T,R>:函数型接口
 * R apply（T t）
 * <p>
 * Predicate<T>:断言型接口
 * boolean test(T t)
 * <p>
 * <p>
 * 其他接口：
 * BiFunction<T,U,R>
 * UnaryOperator<T>
 * BinaryOpertor<T>
 * BiConsumer<T,U>
 * BiPredicte<T,U>
 * 等等......
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-17 00:14
 * @since 1.2.0, 2019-05-17 00:14
 */
public class TestLambda2 {
    //Predicate<T> 断言型接口：
    public void test4() {
        List<String> list = Arrays.asList("hello", "world");
        List<String> strings = filterStr(list, (s) -> s.length() > 3);

    }

    //需求：将满足条件的字符串放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

    //Function<T,R> 函数型接口
    public void test3() {
        String strhandler = strhandler("\t\t\thello world ", (str) -> str.trim());
        System.out.println(strhandler);
    }

    //需求：用于处理字符串
    public String strhandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    //Supplier<T> 供给型接口
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) Math.random() * 100);
        System.out.println(numList);
    }

    //产生一些整数，并放入集合
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    //Consumer<T> 消费性接口
    public void test() {
        happy(1000, (m) -> System.out.println(m));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }
}
