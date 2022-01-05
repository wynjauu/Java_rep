/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.买卖股票;

/**
 * Java_rep: LC188. 买卖股票的最佳时机 IV
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-04 10:44
 * @since 1.2.0, 2021-12-04 10:44
 */
public class LC188 {
    public int maxProfit(int k, int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int day = prices.length;

        //1、定义dp数组,确定状态的含义,,,,,[天数][最大交易次数][是否持有股票],,,,dp方程, 0表示不持有/卖出
        int[][][] dp = new int[day][k + 1][2];

        //3、基础条件初始化
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        //2、状态转移方程
        for (int i = 1; i < day; i++) {
            for (int j = 1; j <= k; j++) {
                //第i天，手里没有股票，完成j笔交易，最大收益(1、前一天持有的，今天卖了 2、前一天手里就没有，所以今天也没有)
                dp[i][j][0] = Math.max(dp[i - 1][j][1] + prices[i], dp[i - 1][j][0]);

                //第i天，手里持有股票，完成j笔交易，最大收益(1、第i天的刚买的 2、前一天手买的，所以今天没有卖)
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
            }
        }
        return dp[day - 1][k][0];
    }
}
