/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

/**
 * Java_rep: NC65 斐波那契数列
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-15 19:43
 * @since 1.2.0, 2021-12-15 19:43
 */
public class NC65 {

    public static int Fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fibonacci(4);
    }
}
