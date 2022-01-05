/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.基础数学;

/**
 * Java_rep: NC151 最大公约数
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-19 21:32
 * @since 1.2.0, 2021-12-19 21:32
 */
public class NC151 {
    /**
     * 辗转相除法
     *
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
