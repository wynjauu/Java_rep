/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

/**
 * java_20190508: LC1094. 拼车
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-21 16:54
 * @since 1.2.0, 2021-11-21 16:54
 */
public class LC1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1024];
        int[] diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] = nums[i - 1];
        }

        for (int x = 0; x < trips.length; x++) {
            int num = trips[x][0];
            int start = trips[x][1];
            int end = trips[x][2];
            diff[start] = diff[start] + num;
            if (end < diff.length) {
                diff[end] = diff[end] - num;
            }
        }

        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int j = 1; j < diff.length; j++) {
            result[j] = result[j - 1] + diff[j];
        }

        for (int y = 0; y < result.length; y++) {
            if (result[y] > capacity) {
                return false;
            }
        }
        return true;
    }
}
