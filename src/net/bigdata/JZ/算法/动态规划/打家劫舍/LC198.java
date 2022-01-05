/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.打家劫舍;

/**
 * Java_rep: LC198. 打家劫舍
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-03 14:19
 * @since 1.2.0, 2021-12-03 14:19
 */
public class LC198 {
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        //1、定义dp数组,确定状态含义:dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]
        int[] dp = new int[n];

        //初始化
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);


        //2、状态怎么转移
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
