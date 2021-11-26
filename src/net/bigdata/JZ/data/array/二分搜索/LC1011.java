/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.data.array.二分搜索;

/**
 * Java_rep: LC1011
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-26 16:53
 * @since 1.2.0, 2021-11-26 16:53
 */
public class LC1011 {
    int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 1;
        for (int weight : weights) {
            lo = Math.max(lo, weight); //船的运载能力至少是最重的那个商品，这样最差情况（一天运一次）一次一个商品也可以运完
            hi = hi + weight; //船的运载能力最大就是一次把所有的商品都运了
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int needD = helper(weights, mid);
            if (needD > days) { //说明运载能力小了,需要增加运载能力
                lo = mid + 1;
            } else if (needD < days) { //说明运载能力过大，用不到days天就运载完了
                hi = mid;
            } else { //运载能力刚好的话，找最小的运载能力的值
                hi = mid;
            }
        }
        return lo;
    }

    //运载能力为x的情况下，需要多少次可以运完
    public static int helper(int[] weights, int x) {
        int count = 0;
        int weight = 0;

        int i = 0;
        while (i < weights.length) {
            if (weight + weights[i] <= x) {
                weight = weight + weights[i];
                i++;
                if (i == weights.length - 1) {
                    count++;
                }
            } else {
                count++;
                weight = 0;
            }
        }
        return count;
    }


    public static int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7};
        int helper = f(weights, 11);
        int helper2 = helper(weights, 11);
        System.out.println(helper + "<<<" + helper2);
    }
}
