/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

/**
 * Java_rep: NC17
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-11 23:56
 * @since 1.2.0, 2021-12-11 23:56
 */
public class NC17 {
    public static int getLongestPalindrome(String A) {
        // write code here
        if (A == null || A.length() == 0) {
            return 0;
        }

        int n = A.length();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        int max = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(i) == A.charAt(j)) {
                    if (A.charAt(i + 1) == A.charAt(j - 1)) {
                        //这里特别注意一点就是：同时确保：dp[i + 1][j - 1]也是回文子串，这样才能跟ij连接组合，那么dp[i + 1][j - 1]是回文字串的话，肯定不等于0
                        //避免babcbcacababb这种当i=0,j=11的时候
                        if (i + 1 <= j - 1 && dp[i + 1][j - 1] != 0) {
                            dp[i][j] = Math.max(dp[i + 1][j - 1] + 2, dp[i][j]);
                        } else if (i + 1 == j) { //i + 1 == j也就是 aa这种情况
                            dp[i][j] = Math.max(2, dp[i][j]);
                        }
                        max = Math.max(dp[i][j], max);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "babcbcacababb";
        getLongestPalindrome(s);
    }
}
