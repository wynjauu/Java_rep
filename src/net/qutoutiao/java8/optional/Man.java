/*
 * Copyright © 2016-2019 net.qutoutiao.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.java8.optional;

/**
 * java_20190508: Man
 *
 * @author wuyang
 * @version 1.2.0, 2019-05-18 15:52
 * @since 1.2.0, 2019-05-18 15:52
 */
public class Man {

    private Godness godness;

    public Man(Godness godness) {
        this.godness = godness;
    }

    public Man() {
    }

    public Godness getGodness() {
        return godness;
    }

    public void setGodness(Godness godness) {
        this.godness = godness;
    }

    @Override
    public String toString() {
        return "Man{" +
                "godness=" + godness +
                '}';
    }
}
