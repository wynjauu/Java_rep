/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组.二分搜索;

/**
 * Java_rep: LC875. 爱吃香蕉的珂珂
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-26 15:13
 * @since 1.2.0, 2021-11-26 15:13
 */
public class LC875 {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;             //每小时最少吃1根
        int hi = high(piles) + 1;   //每小时最多吃数量最大的那一堆香蕉，因为再大了也没有用，一小时最大量也就是数组里面的最大值，再大的话也只能停止等下一小吃
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int needH = getTime(piles, mid); //每小时吃mid根，吃完所有堆香蕉需要多长数据呢
            if (needH > h) {  //吃的时间长于h的话，就需要他提高吃的能力，调大lo
                lo = mid + 1;
            } else if (needH < h) {
                hi = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int getTime(int[] piles, int x) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            int h = piles[i] / x;
            count = count + h;
            if (piles[i] % x > 0) {
                count++;
            }
        }
        return count;
    }

    //最大值
    public int high(int[] piles) {
        int result = Integer.MIN_VALUE;
        for (int pile : piles) {
            if (pile > result) {
                result = pile;
            }
        }
        return result;
    }
}
