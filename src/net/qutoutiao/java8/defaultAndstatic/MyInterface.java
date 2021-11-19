/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.java8.defaultAndstatic;

/**
 * java_20190508: MyInterface
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-18 16:30
 * @since 1.2.0, 2019-05-18 16:30
 */
public interface MyInterface {
    default String getName() {
        return "lll";
    }

}
