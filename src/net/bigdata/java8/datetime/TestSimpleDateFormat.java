/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.java8.datetime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.*;

/**
 * java_20190508: TestSimpleDateFormat
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-18 16:46
 * @since 1.2.0, 2019-05-18 16:46
 */
public class TestSimpleDateFormat {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> call = new Callable<Date>() {

            @Override
            public Date call() throws Exception {
                //return sdf.parse("20161218");  传统SimpleDateFormat线程不安全
                return DateFormatThreadLocal.convert("20161218");//解决传统时间线程不安全问题
            }
        };
        ExecutorService pool = newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(call));

        }

        for (Future<Date> date : results) {
            System.out.println(date.get());
        }

        pool.shutdown();
    }

    public void java8() throws ExecutionException, InterruptedException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        //DateTimeFormatter basicIsoDate = DateTimeFormatter.BASIC_ISO_DATE;//提供的一下/也可以用ofPattern定义自己的
        Callable<LocalDate> call = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20161218", dtf);
            }
        };
        ExecutorService pool = newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(call));
        }

        for (Future<LocalDate> date : results) {
            System.out.println(date.get());
        }

        pool.shutdown();
    }

}
