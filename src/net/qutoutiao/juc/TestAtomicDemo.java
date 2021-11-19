/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of JUC_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一、 i++ 的原子性问题: i++ 的操作实际上分为三个步骤："读-改-写"
 *          int i=10;
 *          i = i++; //结果是10
 *
 *          int temp = i;
 *          i = i+i;
 *          i = temp;
 * 二、 原子变量：jdk1.5后 java.util.concurrent.atomic 包下提供了常用的原子变量：
 *          1、volatile 保证内存可见性
 *          2、CAS（Compare-And-Swap）算法保证数据的原子性
 *              CAS算法是硬件对于并发操作共享数据的支持（我们jvm也支持）
 *              内存值 V
 *              预估值 A
 *              更新值 B
 *              当且仅当V==A时，V=B，否则将不做任何操作
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-09 01:18
 * @since 1.2.0, 2019-05-09 01:18
 */
public class TestAtomicDemo {

    public static void main(String[] args){
        AtomicDemo ad = new AtomicDemo();
        for (int i = 0;i<10;i++){
            new Thread(ad).start();
        }
    }
}

class AtomicDemo implements Runnable {
    //private volatile int serialNumber = 0;
    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());

    }

    public int getSerialNumber() {
        //return serialNumber++;
        return serialNumber.getAndIncrement();
    }

}
