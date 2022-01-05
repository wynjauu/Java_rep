/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.回文;

/**
 * Java_rep: LC516. 最长回文子序列
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-05 16:39
 * @since 1.2.0, 2021-12-05 16:39
 */
public class LC516 {
    public int longestPalindromeSubseq(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        //第一： 定义dp数组,确定状态含义: 定义：对 s[i..j]，最长的回文子序列长度是dp[i][l=j]
        int[][] dp = new int[n][n];

        //第三：初始化值
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        //第二：状态转移方程,当前状态是可以由小的状态得到
        for (int i = n - 1; i >= 0; i--) {
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
