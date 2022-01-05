/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.双指针;

/**
 * Java_rep: NC128 接雨水问题
 * https://labuladong.github.io/algo/4/32/133/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-19 00:48
 * @since 1.2.0, 2021-12-19 00:48
 */
public class NC128 {

    public static long maxWater(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        long water = 0;
        int l_max = 0;
        int r_max = 0;

        while (l < r) {
            l_max = Math.max(l_max, arr[l]);
            r_max = Math.max(r_max, arr[r]);
            if (l_max < r_max) {
                water = water + (l_max - arr[l]);
                l++;
            } else {
                water = water + (r_max - arr[r]);
                r--;
            }
        }
        return water;
    }

    public static long maxWater1(int[] arr) {
        int n = arr.length;
        long water = 0;
        for (int i = 1; i <= n - 2; i++) {
            //找右边
            int r_max = Integer.MIN_VALUE;
            int l_max = Integer.MIN_VALUE;
            for (int l = i; l <= n - 1; l++) {
                r_max = Math.max(r_max, arr[l]);
            }
            //找左边
            for (int r = i; r >= 0; r--) {
                l_max = Math.max(l_max, arr[r]);
            }
            water = water + (Math.min(r_max, l_max) - arr[i]);
        }
        return water;
    }

    public static void main(String[] args) {
        //long test = maxWater(new int[]{3, 1, 2, 5, 2, 4});
    }
}
