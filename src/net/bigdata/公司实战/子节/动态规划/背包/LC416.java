/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.背包;

/**
 * Java_rep: LC416. 分割等和子集
 * https://labuladong.github.io/algo/3/25/81/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-21 11:50
 * @since 1.2.0, 2021-12-21 11:50
 */
public class LC416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        int m = sum / 2;
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j]  //不放第j个，说明已经满了
                            || dp[i - 1][j - nums[i - 1]]; //放第i个，说明i-1个物品容量是j - nums[i - 1]的包已经可以装满，放第i个放好也满了
                } else {
                    dp[i][j] = dp[i - 1][j]; //只能不放
                }
            }
        }
        return dp[n][m];
    }
}
