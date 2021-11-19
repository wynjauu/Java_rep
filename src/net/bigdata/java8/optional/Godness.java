/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.java8.optional;

/**
 * java_20190508: Godness
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-18 15:50
 * @since 1.2.0, 2019-05-18 15:50
 */
public class Godness {

    private String name;

    public Godness(String name) {
        this.name = name;
    }

    public Godness() {
    }

    @Override
    public String toString() {
        return "Godness{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
