/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of JUC_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 一：创建执行线程的方式三：实现Callable接口。相较于实现Runnable接口的方式，方法可以有返回值，并且可以抛出异常
 * 二：执行Callable 方式，需要FutureTask 实现类的支持，用于接收运算结果。FutureTask是Future接口的实现类
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-10 00:57
 * @since 1.2.0, 2019-05-10 00:57
 */
public class TestCallable {

    public static void main(String[] args) {
        ThreadDemo2 td = new ThreadDemo2();

        //1、执行Callable 方式，需要FutureTask 实现类的支持，用于接收运算结果。
        FutureTask<Integer> result = new FutureTask<>(td);

        new Thread(result).start();
        System.out.println("=================");

        //2、接收线程运算后的结果
        try {
            Integer sum = result.get();//FutureTask 也可用于   闭锁
            System.out.println(sum);
            System.out.println("---------------------------");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ThreadDemo2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            //for (int i = 0; i <= 1000000000; i++) {
            System.out.println(i);
            sum += 1;
        }
        return sum;
    }
}
//class ThreadDemo2 implements Runnable {
//
//    @Override
//    public void run() {
//
//        System.out.println();
//    }
//}