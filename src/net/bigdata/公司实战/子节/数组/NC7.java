/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

/**
 * Java_rep: NC7 买卖股票的最好时机(一)
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-15 22:28
 * @since 1.2.0, 2021-12-15 22:28
 */
public class NC7 {

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int k = 1;
        //第i天最大交易次数为i时候是否持有股票
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = 0;
        }
        for (int j = 0; j <= k; j++) {
            if (j == 0) {
                dp[0][j][1] = 0;
            } else {
                dp[0][j][1] = -prices[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][1] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
