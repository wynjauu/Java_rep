/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.买卖股票;

/**
 * Java_rep: LC122.买卖股票的最佳时机 II（简单）
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-04 13:21
 * @since 1.2.0, 2021-12-04 13:21
 */
public class LC122 {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int day = prices.length;
//        int[][] dp = new int[day][2];
//
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];

        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 1; i < day; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        //return dp[day - 1][0];
        return dp_i_0;
    }
}
