/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of JUC_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.juc;

/**
 * 题目：判断打印的是"one" or "two"
 * <p>
 * 1、两个普通同步方法，两个线程，标准打印，打印？//one two
 * 2、薪增Thread.sleep() 给getOne()，打印？ //one two
 * 3、新增普通方法getThree()，打印？three one two
 * 4、两个普通同步方法，两个Number对象。打印？//two one
 * 5、修改getOne()为静态同步方法，打印？two one
 * 6、修改两个方法均为静态同步方法，一个Number对象？ //one two
 * 7、一个静态同步方法，一个非静态同步方法，两个Number对象？//two one
 * 8、两个静态同步方法，两个Number对象？ //one two
 * <p>
 * 线程八锁的关键：
 * 1、非静态方法的锁默认为 this,静态方法的锁为Class实例
 * 2、在某一个时刻内，只能有一个线程持有锁，无论几个方法。
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-11 23:35
 * @since 1.2.0, 2019-05-11 23:35
 */
public class TestThread8Monitor {
    public static void main(String[] args) {
        Number number = new Number();
        Number number2 = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Number.getOne();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Number.getTwo();
                number2.getTwo();
            }
        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                number.getThree();
//            }
//        }).start();
    }
}

class Number {
    public static synchronized void getOne() {//Number.class
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("one");
    }

    public synchronized void getTwo() {//this
        System.out.println("two");
    }

//    public void getThree() {
//        System.out.println("three");
//    }
}