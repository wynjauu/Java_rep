/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.买卖股票;

/**
 * Java_rep: LC309. 最佳买卖股票时机含冷冻期
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-04 14:52
 * @since 1.2.0, 2021-12-04 14:52
 */
public class LC309 {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int n = prices.length;

        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (i - 2 == -1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
