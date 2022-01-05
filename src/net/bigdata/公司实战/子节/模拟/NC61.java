/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.模拟;

import java.util.Arrays;

/**
 * Java_rep: 剑指 Offer 61. 扑克牌中的顺子
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-20 20:00
 * @since 1.2.0, 2021-12-20 20:00
 */
public class NC61 {
    public static boolean isStraight(int[] nums) {
        if (null == nums || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        int zeroCount = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }
            if (i == 0) {
                continue;
            }
            if (nums[i] != nums[i - 1] + 1) {
                if (nums[i - 1] == 0) {
                    continue;
                }
                if (nums[i] == nums[i - 1]) {
                    return false;
                }
                if (zeroCount - (nums[i] - nums[i - 1] - 1) >= 0) {
                    zeroCount = zeroCount - (nums[i] - nums[i - 1] - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isStraight(new int[]{0, 0, 8, 5, 4});
    }
}
