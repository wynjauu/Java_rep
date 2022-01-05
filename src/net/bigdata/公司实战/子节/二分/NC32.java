/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.二分;

/**
 * Java_rep: NC32 求平方根
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-19 19:31
 * @since 1.2.0, 2021-12-19 19:31
 */
public class NC32 {
    public static int sqrt(int x) {
        // write code here
        int i = 0;
        int j = x;
        int res = -1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(909520789));
    }
}
