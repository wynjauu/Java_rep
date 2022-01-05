/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.子序列类型;

/**
 * Java_rep: LC712. 两个字符串的最小ASCII删除和
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-01 14:28
 * @since 1.2.0, 2021-12-01 14:28
 */
public class LC712 {
    public int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        //1、定义dp数组
        int[][] dp = new int[l1 + 1][l2 + 1];

        //3、确定初始化值
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= l2; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        //2、状态转移方程
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + s2.charAt(j - 1) + s1.charAt(i - 1),
                            Math.min(
                                    dp[i - 1][j] + s1.charAt(i - 1),
                                    dp[i][j - 1] + s2.charAt(j - 1)
                            )
                    );
                }
            }
        }
        return dp[l1][l2];
    }
}
