/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.买卖股票;

/**
 * Java_rep: LC714. 买卖股票的最佳时机含手续费
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-04 15:14
 * @since 1.2.0, 2021-12-04 15:14
 */
public class LC714 {
    public int maxProfit(int[] prices, int fee) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int n = prices.length;

        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }
}
