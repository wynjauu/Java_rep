/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.java8.annotation;

import java.lang.reflect.Method;

/**
 * java_20190508: TestAnnoation
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-19 15:07
 * @since 1.2.0, 2019-05-19 15:07
 */
public class TestAnnoation {

    @MyAnnoation("world")
    @MyAnnoation("hello")
    public void show(@MyAnnoation("abc") String string) {
    }

    public void test() throws NoSuchMethodException {
        Class<TestAnnoation> clazz = TestAnnoation.class;
        Method m1 = clazz.getMethod("show");

        MyAnnoation[] mas = m1.getAnnotationsByType(MyAnnoation.class);

        for (MyAnnoation myAnnoation : mas) {
            System.out.println(myAnnoation.value());
        }
    }
}
