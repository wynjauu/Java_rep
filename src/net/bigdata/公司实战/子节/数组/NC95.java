/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

import java.util.Arrays;

/**
 * Java_rep: NC95 数组中的最长连续子序列
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-16 19:40
 * @since 1.2.0, 2021-12-16 19:40
 */
public class NC95 {

    public int MLS(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
            } else if (arr[i] == arr[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
