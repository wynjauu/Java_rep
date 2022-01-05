/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.子序列类型;

/**
 * Java_rep: LC1143.最长公共子序列（中等）
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-01 10:08
 * @since 1.2.0, 2021-12-01 10:08
 */
public class LC1413 {

    public int longestCommonSubsequence(String text1, String text2) {
        if (null == text1 || null == text2) {
            return 0;
        }

        int l1 = text1.length();
        int l2 = text2.length();

        //第一步：定义dp数组
        int[][] dp = new int[l1 + 1][l2 + 1];

        //第二步：base case
        //[0][0] 到 [i][j]的公共子序列是0

        //第三步：动态转移方程
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1])
                            , dp[i - 1][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
