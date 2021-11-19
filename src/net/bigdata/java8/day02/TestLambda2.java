/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.java8.day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
     * 一、Lambda 表达式的基础语法：Java8引入新的操作符号"->"该操作符成为箭头操作符或者Lambda操作符
 * <p>
 * 左侧：Lambda 表达式的参数列表，参数个数与接口参数对应
 * 右侧：Lambda 表达式中所需执行的功能，即：Lambda体，也是对接口的实现
 * <p>
 * 语法格式一：无参数，无返回值:()->System.out.println("hello world");
 * 语法格式二：一个参数，无返回值:(x) -> System.out.println(x);
 * 语法格式三：如只有一个参数，小括号可以不写:x -> System.out.println(x);
 * 语法格式四：有两个或者多个参数，并且Lambda体中有多条语句，需要用{}把语句扩起来
 * 语法格式五：若Lambda体中只有一条语句，return和大括号都可以省略不写
 * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVN编译器可以通过上下文推断出类型
 * <p>
 * 上：左右遇一括号省
 * 下：左侧推断类型省
 * 横批：能省则省
 * <p>
 * 二、Lambda 表达式需要"函数式接口"的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解@FunctionalInterface修饰
 * 可以检查是否是函数式接口
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-14 00:41
 * @since 1.2.0, 2019-05-14 00:41
 */
public class TestLambda2 {

    public void test1() {
        //局部内部类中用到同级别的变量，在Java1.7以前则局部变量必须是final的,1.8以后可以不用final修饰，
        // 但是依然不能修改，因此底层依然是final，会默认加上
        int num = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World" + num);
            }
        };
        r.run();

        System.out.println("-----------------------");

        Runnable r1 = () -> System.out.println("Hello World" + num);
        r1.run();
    }

    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        Consumer<String> con2 = x -> System.out.println(x);
        con.accept("hello world!");
    }

    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("hello");
            return Integer.compare(x, y);
        };
    }

    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    public void test5() {
        Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);

        String[] strs = {"12", "34"};
//        String[] strs2;
//        strs2 = {"12", "34"};  NOT SUPPRESS
        List<String> list = new ArrayList<>();
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }

    //需求：对一个数据进行运算
    public void test() {
        Integer num = operation(100, (x) -> x * x);
        System.out.println(num);
        System.out.println(operation(100, (y) -> y + 200));

    }

}
