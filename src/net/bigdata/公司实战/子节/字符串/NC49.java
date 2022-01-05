/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

/**
 * Java_rep: NC49 最长的括号子串
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-13 20:20
 * @since 1.2.0, 2021-12-13 20:20
 */
public class NC49 {

    public int longestValidParentheses(String str) {
        // write code here
        if (str == null || str.length() == 0) {
            return 0;
        }

        int l = str.length();

        // 以i结尾的字符串是子串的长度是dp[i]
        int[] dp = new int[l];
        dp[0] = 0;
        int maxlen = 0;
        for (int i = 1; i < l; i++) {
            char c = str.charAt(i);
            if (c == ')') {
                if (str.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = 2 + dp[i - 2];
                    } else {
                        dp[i] = 2;
                    }
                } else if (i - dp[i - 1] - 1 >= 0 && str.charAt(i - dp[i - 1] - 1) == '(') {
                    if (i - dp[i - 1] >= 2) {
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
                maxlen = Math.max(maxlen, dp[i]);
            } else {
                dp[i] = 0;
            }
        }
        return maxlen;
    }
}
