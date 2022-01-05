/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.子序列类型;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Java_rep: LC354. 俄罗斯套娃信封问题
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-30 23:00
 * @since 1.2.0, 2021-11-30 23:00
 */
public class LC354 {
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        int[] hi = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            hi[i] = envelopes[i][1];
        }
        return helper(hi);
    }


    public int helper(int[] nums) {
        int n = nums.length;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
