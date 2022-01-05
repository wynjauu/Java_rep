/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划;

/**
 * Java_rep: NC116 把数字翻译成字符串
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-21 16:38
 * @since 1.2.0, 2021-12-21 16:38
 */
public class NC116 {
    public int solve(String nums) {
        // write code here
        //dp
        int len = nums.length();
        if (len == 0 || nums.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; ++i) {
            char c = nums.charAt(i - 1);
            if (c != '0') {
                dp[i] = dp[i - 1];
            }
            if (i - 2 >= 0) {
                int val = Integer.valueOf(nums.substring(i - 2, i));
                if (val >= 10 && val <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len];
    }
}
