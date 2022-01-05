/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.背包类型;

/**
 * Java_rep: LC416. 分割等和子集
 * 0-1背包
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-02 15:17
 * @since 1.2.0, 2021-12-02 15:17
 */
public class LC416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;

        //1、定义dp数组
        boolean[][] dp = new boolean[n + 1][sum + 1];

        //3、初始值
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        //2、状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    /**
     * 优化
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;

        //1、定义dp数组
        boolean[] dp = new boolean[sum + 1];

        //2、初始值
        dp[0] = true;

        //3、状态转移方程
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }

}
