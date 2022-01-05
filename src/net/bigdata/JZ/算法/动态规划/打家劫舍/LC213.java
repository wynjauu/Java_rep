/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.打家劫舍;

/**
 * Java_rep: LC213.打家劫舍II（中等）
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-03 16:26
 * @since 1.2.0, 2021-12-03 16:26
 */
public class LC213 {
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    public int helper(int[] nums, int start, int end) {
        //1、定义dp数组，确定状态含义
        int n = end + 1;
        int[] dp = new int[n];

        //初始化值
        dp[start] = nums[start];
        dp[start + 1] = Math.max(dp[start], nums[start + 1]);

        //3、状体转移方程
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
