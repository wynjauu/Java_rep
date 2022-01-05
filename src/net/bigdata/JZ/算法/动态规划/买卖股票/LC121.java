/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.买卖股票;

/**
 * Java_rep: LC121.买卖股票的最佳时机（简单）
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-04 12:09
 * @since 1.2.0, 2021-12-04 12:09
 */
public class LC121 {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int n = prices.length;

        //定义状态dp数组[天数][最大交易次数][是否持有股票]
        int[][][] dp = new int[n][2][2];

        for (int j = 0; j < 2; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }
        //状态转移方程
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 2; j++) {
                //条件一：如果第i天手里没有持有股票的话，1、昨天没有持有，今天也没有买入，所以今天也不会持有 2、昨天持有股票，但是今天卖了
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                //条件二：如果第i天手里持有股票，1、昨天没有持有，今天买入了一股  2、昨天持有一股，今天没有卖
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
            }
        }
        return dp[n - 1][1][0];
    }

    public int maxProfit2(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int n = prices.length;

        //定义状态dp数组[天数][最大交易次数][是否持有股票]
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        //状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }
}
