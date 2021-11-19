/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of JUC_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者和消费者案例
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-10 23:43
 * @since 1.2.0, 2019-05-10 23:43
 */
public class TestfProductorAndConsumerForLock {
    public static void main(String[] args) {
        ClerkLock clerk = new ClerkLock();

        ProductorLock pro = new ProductorLock(clerk);
        ConsumerLock con = new ConsumerLock(clerk);

        new Thread(pro, "生产者A").start();
        new Thread(con, "消费者B").start();

        new Thread(pro, "生产者C").start();
        new Thread(con, "消费者D").start();

    }
}

//店员
class ClerkLock {
    private int product = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //进货
    public void get() {
        lock.lock();
        try {
            while (product >= 1) {
                System.out.println("产品已满！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            } //else {
            System.out.println(Thread.currentThread().getName() + ":" + ++product);
            condition.signalAll();
            // }
        } finally {
            lock.unlock();
        }
    }


    //卖货
    public void sale() {
        lock.lock();
        try {
            while (product <= 0) {
                System.out.println("缺货！");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                }
            }//  else {
            System.out.println(Thread.currentThread().getName() + ":" + --product);
            condition.signalAll();
            //}
        } finally {
            lock.unlock();
        }
    }
}

//生产者
class ProductorLock implements Runnable {

    private ClerkLock clerk;

    public ProductorLock(ClerkLock clerk) {
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
class ConsumerLock implements Runnable {

    private ClerkLock clerk;

    public ConsumerLock(ClerkLock clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}