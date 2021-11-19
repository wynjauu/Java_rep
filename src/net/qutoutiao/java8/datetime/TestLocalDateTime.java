/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * java_20190508: TestLocalDateTime
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-18 17:06
 * @since 1.2.0, 2019-05-18 17:06
 */
public class TestLocalDateTime {

    public static void main(String[] args) {
        test3();
    }

    /**
     * localDate  localTime localDateTime
     */
    public void test() {
        LocalDateTime ldt = LocalDateTime.now();//当前时间

        LocalDateTime dateTime = LocalDateTime.of(2019, 05, 18, 13, 13, 13);//指定时间

        LocalDateTime dateTime1 = dateTime.plusYears(1);
        Month month = dateTime1.getMonth();
    }

    /**
     * Instant:时间戳（以Unix元年：1970年1月1日 00：00：00到某个时间之间的毫秒值）
     */
    public static void test2() {
        Instant insq = Instant.now();//默认获取UTC时区
        System.out.println(insq); //2019-05-18T10:56:28.644Z

        insq.toEpochMilli();
        Instant instant = Instant.ofEpochSecond(60);
        System.out.println(instant);

        OffsetDateTime offsetDateTime = insq.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2019-05-18T18:56:28.644+08:00

        System.out.println(offsetDateTime.toEpochSecond());//转为秒

    }

    /**
     * Duration:计算两个"时间"之间的间隔
     * Period:计算两个"日期"之间的间隔
     */
    public static void test3() {
        Instant ins1 = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        Instant ins2 = Instant.now();

        Duration between = Duration.between(ins1, ins2);
        System.out.println(between.toMillis());


        LocalTime lt1 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        LocalTime lt2 = LocalTime.now();

        Duration between2 = Duration.between(lt1, lt2);
        System.out.println(between2.toMillis());


        LocalDate ld1 = LocalDate.of(2018, 1, 1);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1, ld2);
        System.out.println(period.getDays());
    }

    /**
     * TemporalAdjuster:s时间校正器
     */
    public static void test5() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);


        LocalDateTime localDateTime = ldt.withDayOfMonth(10);
        System.out.println(localDateTime);

        localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        //自定义：下一个工作日
        LocalDateTime dateTime = localDateTime.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dow = ldt4.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });
        System.out.println(dateTime);
    }

    /**
     * DateTimeFormatter:格式化时间/日期
     */
    public void test6() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);


        LocalDateTime parse = LocalDateTime.parse(strDate2, dtf2);
        System.out.println(parse);
    }

    /**
     * zonedDate、ZonedTime、ZonedDateTime
     */
    public void test7() {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();//获取所有支持的时区
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ldt2.atZone(ZoneId.of("Europe/Tallinn"));
        System.out.println(zonedDateTime);

        LocalDateTime ldt3 = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        ZonedDateTime zonedDateTime3 = ldt2.atZone(ZoneId.of("Asia/Shanghai"));
    }
}
