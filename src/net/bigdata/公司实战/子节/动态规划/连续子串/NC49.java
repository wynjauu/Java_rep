/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.连续子串;

/**
 * Java_rep: NC49 最长的括号子串
 * https://www.cnblogs.com/cxyxz/p/15563819.html
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-11 18:08
 * @since 1.2.0, 2021-12-11 18:08
 */
public class NC49 {
    public int longestValidParentheses(String s) {
        // write code here
        if (null == s || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 0;
        int maxlen = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = 2 + dp[i - 2];
                    } else {
                        dp[i] = 2;
                    }
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if (i - dp[i - 1] >= 2) {
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    } else {
                        dp[i] = dp[i - 1] + 2 + 0;
                    }
                }
                maxlen = Math.max(maxlen, dp[i]);
            } else {
                dp[i] = 0;//因为此时：s.charAt(i) == '('是以(结尾的，因为dp定义的是dp[i]表示字串以s.charAt(i)结尾，所以不能使用s.charAt(i)构成最长字串
            }
        }
        return maxlen;
    }
}
