/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.背包;

/**
 * Java_rep: LC518. 零钱兑换 II
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-21 14:30
 * @since 1.2.0, 2021-12-21 14:30
 */
public class LC518 {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] //不选第i个，因为第i-1个容量为j的时候已经装满了
                            + dp[i][j - coins[i - 1]]; //选择第i个，说明在不选第i个的时候，容量为j-coins[i-1]已经满了，这里注意因为可以重复选，所以第i个不选之前也可能是第i个装满的
                } else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }
        return dp[n][amount];
    }

}
