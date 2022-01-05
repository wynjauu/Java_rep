/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.基础数学;

/**
 * Java_rep: NC79 丑数
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-19 21:22
 * @since 1.2.0, 2021-12-19 21:22
 */
public class NC79 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] dp = new int[index];
        dp[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        for (int i = 1; i < index; i++) {
            dp[i] = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            if (dp[i2] * 2 == dp[i]) {
                i2++;
            }
            if (dp[i3] * 3 == dp[i]) {
                i3++;
            }
            if (dp[i5] * 5 == dp[i]) {
                i5++;
            }
        }
        return dp[index - 1];
    }
}
