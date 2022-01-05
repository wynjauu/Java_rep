/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.背包类型;

/**
 * Java_rep: LC518. 零钱兑换 II
 * 完全背包
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-02 17:38
 * @since 1.2.0, 2021-12-02 17:38
 */
public class LC518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        //1、定义dp数组
        int[][] dp = new int[n + 1][amount + 1];

        //3、初始化值
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        //2、状态转移方程
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    /**
     * 优化
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        int n = coins.length;

        //1、定义dp数组
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
