/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.连续子串;

/**
 * Java_rep: NC17 最长回文子串
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-10 14:41
 * @since 1.2.0, 2021-12-10 14:41
 */
public class NC17 {
    public static int getLongestPalindrome(String A) {
        // write code here
        if (null == A) {
            return 0;
        }
        int n = A.length();
        //dp[i][j]表示A[i]至A[j]所表示的子串是否是回文子串
        boolean[][] dp = new boolean[n][n];

        //基础条件
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        //状态转移方程
        int res = 1;
        /**
         * https://writings.sh/post/algorithm-longest-palindromic-substring#%E4%BA%8C%E7%BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E6%96%B9%E6%B3%95
         * https://blog.csdn.net/qq_42265608/article/details/89514122
         */
        for (int i = n - 1; i >= 0; i--) {//i和j从小到大的顺序来枚举子串的两个端点,然后更新dp[i]lj],会无法保证dp[i + 1][ j- 1]已经被计算过,从而无法得到正确的dp[i][i]。
            for (int j = i + 1; j < n; j++) {
                char left = A.charAt(i);
                char right = A.charAt(j);
                if (left == right) {
                    if (i + 1 == j) {
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        }
                    }
                    if (dp[i][j]) {
                        res = Math.max(res, j - i + 1);
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return res;
    }

    public int getLongestPalindrome2(String A) {
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
                        if (i + 1 <= j - 1 && dp[i + 1][j - 1] != 0) {
                            dp[i][j] = Math.max(dp[i + 1][j - 1] + 2, dp[i][j]);
                        } else if (i + 1 == j) {
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
        String s = "badfab ";
        getLongestPalindrome(s);
    }
}
