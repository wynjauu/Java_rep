/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.java8.defaultAndstatic;

/**
 * java_20190508: MyFun
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-18 16:11
 * @since 1.2.0, 2019-05-18 16:11
 */
public interface MyFun<T> {
    T func(int a);

    default String getName() {
        return "hahaha";
    }

    public static String show() {
        return "lllllllll";
    }
}

