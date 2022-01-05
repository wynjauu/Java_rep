/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.子序列类型;

/**
 * Java_rep: LC516. 最长回文子序列
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-29 22:42
 * @since 1.2.0, 2021-11-29 22:42
 */
public class LC516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        //初始化base
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
