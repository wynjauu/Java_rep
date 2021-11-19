/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.java8.stream;

import net.bigdata.java8.day01.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * java_20190508: TestStreamAPI2
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-18 14:22
 * @since 1.2.0, 2019-05-18 14:22
 */
public class TestStreamAPI2 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 9999.99),
            new Employee("王五", 59, 9999.99),
            new Employee("赵六", 20, 33333),
            new Employee("田七", 18, 111));


    //1、给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？？给定【1，2，3，4，5】 应该返回【2，4，6，8，10】
    public void test() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(nums)
                .map((x) -> x * x)
                .forEach(System.out::println);
    }

    //2、有多少个Employee
    public void test2() {
        Optional<Integer> count = employees.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
    }

}
