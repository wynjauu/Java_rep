/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of JUC_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.juc;

/**
 * 一、volatitle 关键字：当多个线程进行操作共享数据时，可以保证内存中的数据可见。
 * 底层其实是调用计算机底层的内存栅栏实时对变量进行刷新，相当于多线程对共享变量的所有操作都在主存中进行的，每次都去读取主存，但是也会对性能有影响。
 * 只是相较于synchronized是一种较为轻量级的同步策略
 * 注意：
 * 1、volatitle  不具备"互斥性"，synchronized有互斥性
 * 2、volatitle  不能保证变量的"原子性"
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-09 00:24
 * @since 1.2.0, 2019-05-09 00:24
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();
        while (true) {
            //synchronized (td) {
            if (td.isFlag()) {
                System.out.println("--------------");
                break;
            }
            //}
        }
        // 1、此时有两个线程：一个td线程修改值、一个main线程while循环读取值打印
        // 2、内存可见性问题是，当多个线程操作共享数据时，彼此不可见
        // 3、牵扯到内存模型，共享变量与线程自己的运行区
        // 4、解决方法：1、加锁synchronized，但是效率底下 2、volatile修饰共享变量

    }
}

class ThreadDemo implements Runnable {

    private volatile boolean flag = false;

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = true;
        System.out.println("flag=" + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
