/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.子序列类型;

/**
 * Java_rep: LC53. 最大子数组和
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-30 23:37
 * @since 1.2.0, 2021-11-30 23:37
 */
public class LC53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        //第一步：定义 dp 数组（定义数组元素的含义）
        int[] dp = new int[n];

        //第二步：确定base case（找出初始值）
        dp[0] = nums[0];

        //第三步：定义状态转移方程（找出数组元素之间的关系式）
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
