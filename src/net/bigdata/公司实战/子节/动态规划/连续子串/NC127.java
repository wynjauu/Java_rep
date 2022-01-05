/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.连续子串;

/**
 * Java_rep: NC127 最长公共子串
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-10 11:27
 * @since 1.2.0, 2021-12-10 11:27
 */
public class NC127 {
    public static String LCS(String str1, String str2) {
        // write code here
        if (null == str1 || null == str2) {
            return null;
        }
        int n = str1.length();
        int m = str2.length();

        //定义dp数组,,, dp[i][j] 表示以str1[i]结尾，str2[j]结尾的最长公共子串长度
        int[][] dp = new int[n][m];

        //确定基础条件
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < m; j++) {
            if (str1.charAt(0) == str2.charAt(j)) {
                dp[0][j] = 1;
            }
        }

        int max = 0;
        String res = "";
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        res = str1.substring(i - max + 1, i + 1);
                    }
                } else {
                    dp[i][j] = 0;//看dp定义，这边肯定是0
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "MjL9K";
        String str2 = "DjLz90";
        System.out.println(str1.substring(1,5));
        //System.out.println(LCS(str1, str2));
    }
}
