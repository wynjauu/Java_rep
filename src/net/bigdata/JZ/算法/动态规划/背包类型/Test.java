/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.背包类型;

/**
 * Java_rep: Test
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 10:24
 * @since 1.2.0, 2021-12-06 10:24
 */
public class Test {
    public static int findTargetSumWays(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int n : nums) sum += n;
        // 这两种情况，不可能存在合法的子集划分
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        if(nums.length==1 && target != nums[0]){
            return 0;
        }
        return subsets(nums, (sum + target) / 2);
    }

    static int subsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    // 两种选择的结果之和
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    // 背包的空间不足，只能选择不装物品 i
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100};
        int target = -200;
        findTargetSumWays(nums, target);
    }
}
