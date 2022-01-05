/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.回文;

/**
 * Java_rep: LC1312. 让字符串成为回文串的最少插入次数
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-05 16:05
 * @since 1.2.0, 2021-12-05 16:05
 */
public class LC1312 {
    public int minInsertions(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        //定义dp数组，确定状态含义: 定义：对 s[i..j]，最少需要插入 dp[i][j] 次才能变成回文
        int[][] dp = new int[n][n];

        //base case 一个字符本身也是回文
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        return dp[0][n - 1];
    }
}
