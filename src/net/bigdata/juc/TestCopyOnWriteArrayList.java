/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of JUC_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList/CopyOnWriteArraySet ： "写入并复制"
 * 注意：添加操作多时，效率低，因为每次添加时都会进行复制，开销非常大。并发迭代操作多时可以选择。
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-10 00:05
 * @since 1.2.0, 2019-05-10 00:05
 */
public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        HelloThread ht = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(ht).start();
        }
    }
}

class HelloThread implements Runnable {

    //原来解决线程安全问题
    //private static List<String> list = Collections.synchronizedList(new ArrayList<String>());

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("A");
        list.add("B");
        list.add("C");
    }

    @Override
    public void run() {

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            list.add("AA");
        }
    }
}
