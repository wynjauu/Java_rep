/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.子序列;

/**
 * Java_rep: NC92 最长公共子序列(二)
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-10 23:50
 * @since 1.2.0, 2021-12-10 23:50
 */
public class NC92 {
    public static String LCS(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        String[][] dp = new String[n1 + 1][n2 + 1];//表示当处理到s1的第i个元素和s2的第j个元素时公共子序列的长度

        //
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = ""; //因为 j=0的时候，s2=""
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = ""; //因为 i=0的时候，s1=""
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {//如果相同的话
//                     dp[i][j]=dp[i-1][j-1]+1;
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
//                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        if (dp[n1][n2].equals("")) {
            return "-1";
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "1A2C";
        String s2 = "B1D2";

        System.out.println(LCS(s1, s2));
    }
}
