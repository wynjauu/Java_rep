/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

/**
 * java_20190508: LC303. 区域和检索 - 数组不可变
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-20 20:53
 * @since 1.2.0, 2021-11-20 20:53
 */
public class LC303 {

    int[] preNums;

    public LC303(int[] nums) {
        preNums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preNums[i] = nums[i - 1] + preNums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preNums[right + 1] - preNums[left];
    }
}
