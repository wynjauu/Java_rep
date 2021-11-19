/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of JUC_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.juc;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * JUC_20190508: TestForkJoinPool
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-13 00:21
 * @since 1.2.0, 2019-05-13 00:21
 */
public class TestForkJoinPool {
    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 10000000000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("haoshi:" + Duration.between(start, end).toMillis());

    }


    public void test() {
        Instant start = Instant.now();

        long sum = 0L;
        for (long i = 0; i <= 10000000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("haoshi:" + Duration.between(start, end).toMillis());
    }

    /**
     * java8 新特性
     */
    public void test2() {
        Long sum = LongStream.rangeClosed(0L, 10000000000000L)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(sum);
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {//区别与RecursiveAction，RecursiveAction是没有返回值的

    private static final long serialVersionUID = -6923338243795737940L;

    private long start;
    private long end;

    private static final long THURSHOLD = 10000L;//临界值

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THURSHOLD) {
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
            left.fork();//进行拆分，同时压入线程队列

            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }
}