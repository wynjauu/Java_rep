/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划;

/**
 * JZ10 斐波那契数列
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-24 21:30
 * @since 1.2.0, 2021-10-24 21:30
 */
public class JZ10 {


    public int solution2(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        // 状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int solution(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
