/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.java8.day03;


import net.qutoutiao.java8.day01.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1、调用Collections.sort()方法，通过定制排序比较两个Employee（先按照年龄比，年龄相同按姓名比），使用Lambada作为参数传递。
 * <p>
 * 2、（1）声明函数式接口，接口中声明抽象方法，public String getValue(String str);
 * (2) 声明类TestLambada,类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值
 * （3） 再将一个字符串的第2个和第4个索引位置进行截取子串。
 * <p>
 * 3、（1）声明一个带两个泛型的函数式接口，泛型类型为<T,R> T为参数，R为返回值
 * （2）接口中声明对应抽象方法。
 * （3）在TestLambda类中声明方法，使用接口作为参数，，计算两个long型参数的和。
 * （4）再计算两个long型参数的乘积。
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-16 23:42
 * @since 1.2.0, 2019-05-16 23:42
 */
public class TestLambda {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 9999.99),
            new Employee("王五", 59, 9999.99),
            new Employee("赵六", 20, 33333),
            new Employee("田七", 18, 111)
    );

    public void test1() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee emp : employees) {
            System.out.println(emp);
        }

    }

    public void test2() {
        String s = strHandler("\t\tw hello world ", (str) -> str.trim());
        System.out.println(s);
    }

    //需求：用于处理字符串
    public String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    public void test3() {
        op(100L, 200L, (x, y) -> x + y);
    }

    //需求：对两个long 型数据进行处理
    public Long op(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        return mf.getValue(l1, l2);
    }
}
