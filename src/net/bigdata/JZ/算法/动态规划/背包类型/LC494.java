/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.背包类型;

/**
 * Java_rep: LC494. 目标和（中等）
 * sum(A) - sum(B) = target
 * sum(A) = target + sum(B)
 * sum(A) + sum(A) = target + sum(B) + sum(A)
 * sum(A) = (target + sum)/2
 * 0-1背包
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-05 23:31
 * @since 1.2.0, 2021-12-05 23:31
 */
public class LC494 {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // 这两种情况，不可能存在合法的子集划分
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        return helper(nums, (sum + target) / 2);
    }

    public static int helper(int[] nums, int sum) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        // 1、确定状态和选择
        int[][] dp = new int[n + 1][sum + 1];

        //3、初始化基础条件
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = 0;
        }

        //2、状态转移逻辑
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < nums[i - 1]) {      //放不下
                    dp[i][j] = dp[i - 1][j];
                } else {    //能放的下，但是可以放也可以不放
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        findTargetSumWays(nums, target);
    }
}
