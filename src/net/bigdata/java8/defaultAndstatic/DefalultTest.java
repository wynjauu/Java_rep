/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.java8.defaultAndstatic;

/**
 * java_20190508: DefalultTest
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-18 16:20
 * @since 1.2.0, 2019-05-18 16:20
 */
public class DefalultTest {
    public static void main(String[] args) {
        MyDefaultClass myDefaultClass = new MyDefaultClass();
        String name = myDefaultClass.getName();
        System.out.println(name);//运行之后调用的是实体类中getName方法（类优先原则）

        String show = MyFun.show();
        System.out.println(show);
    }
}
