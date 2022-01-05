/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.股票;

/**
 * Java_rep: Demo
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 188. 买卖股票的最佳时机 IV
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-11 13:00
 * @since 1.2.0, 2021-12-11 13:00
 */
public class Demo {
    public int maxProfit(int k, int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int n = prices.length;

        //[第几天][最多交易k次][是的持有股票]
        int[][][] dp = new int[n][k + 1][2];

        //初始化条件
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
