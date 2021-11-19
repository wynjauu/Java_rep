/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of JUC_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.juc;

import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.*;

/**
 * 一、线程池:提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建与销毁额外的开销，提高了响应的速度。
 * <p>
 * 二、线程池的体系结构：
 * java.util.concurrent.Executor:负责线程的使用与调度的根接口
 *   |--**ExecutorService   子接口：线程池的主要接口
 *      |--ThreadPoolExecutor  线程池的实现类
 *      |--ScheduledExecutorService 子接口：负责线程的调度
 *         |--ScheduledThreadPoolExecutor:继承了ThreadPoolExecutor，实现了ScheduledExecutorService，既有线程池的功能又可以做线程调度
 *
 * 三、工具类：Executors
 * ExecutorService newFixedThreadPool(): 创建固定大小的线程池
 * ExecutorService newCachedThreadPool():缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量
 * ExecutorService newSingleThreadExecutor():创建单个线程池。线程池中只有一个线程
 * ScheduledExecutorService newScheduledThreadPool():创建固定大小的线程，可以延迟或定时的执行任务。
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-12 00:26
 * @since 1.2.0, 2019-05-12 00:26
 */
public class TestScheduledThreadPool {
    public static void main(String[] args) throws Exception {

        ScheduledExecutorService pool = newScheduledThreadPool(5);
        for (int i=0;i<5;i++){
            Future<Integer> result = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);//生成随机数
                    System.out.println(Thread.currentThread().getName()+" : "+num);
                    return num;
                }
            },1, TimeUnit.SECONDS);
            System.out.println(result.get());
        }
        pool.shutdown();

    }
}
