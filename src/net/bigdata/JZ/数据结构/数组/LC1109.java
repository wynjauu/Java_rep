/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

/**
 * java_20190508: LC1109. 航班预订统计
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-21 15:50
 * @since 1.2.0, 2021-11-21 15:50
 */
public class LC1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] nums = new int[n];
        //构造差分数组
        int[] diff = new int[n];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        //
        for (int x = 0; x < bookings.length; x++) {
            int start = bookings[x][0];
            int end = bookings[x][1];
            int num = bookings[x][2];
            diff[start - 1] = diff[start - 1] + num;
            if (end < diff.length) {
                diff[end] = diff[end] - num;
            }
        }

        //
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int j = 1; j < diff.length; j++) {
            result[j] = result[j - 1] + diff[j];
        }
        return result;
    }
}
