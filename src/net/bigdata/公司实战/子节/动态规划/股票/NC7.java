/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.股票;

/**
 * Java_rep: NC7 买卖股票的最好时机(一)
 * https://labuladong.github.io/algo/3/26/94/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-10 22:54
 * @since 1.2.0, 2021-12-10 22:54
 */
public class NC7 {
    public int maxProfit(int[] prices) {
        // write code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);//注意这里
        }
        return dp[n - 1][0];
    }
}
