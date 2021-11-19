/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of JUC_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.juc;

/**
 * 生产者和消费者案例
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-10 23:43
 * @since 1.2.0, 2019-05-10 23:43
 */
public class TestfProductorAndConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor pro = new Productor(clerk);
        Consumer con = new Consumer(clerk);

        new Thread(pro, "生产者A").start();
        new Thread(con, "消费者B").start();

        new Thread(pro, "生产者C").start();
        new Thread(con, "消费者D").start();

    }
}

//店员
class Clerk {
    private int product = 0;

    //进货
    public synchronized void get() {
        while (product >= 1) {//为了避免虚假唤醒问题，wait应该总是使用在循环中
            System.out.println("产品已满！");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        } //else {
        System.out.println(Thread.currentThread().getName() + ":" + ++product);
        this.notifyAll();
        // }
    }


    //卖货
    public synchronized void sale() {
        while (product <= 0) {
            System.out.println("缺货！");
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }//  else {
        System.out.println(Thread.currentThread().getName() + ":" + --product);
        this.notifyAll();
        //}
    }
}

//生产者
class Productor implements Runnable {

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            clerk.get();
        }
    }
}

//消费者
class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}