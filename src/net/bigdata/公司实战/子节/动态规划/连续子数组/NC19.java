/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.连续子数组;

/**
 * Java_rep: NC19 连续子数组的最大和
 * 对比：NC83 连续子数组最大乘积
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-10 10:06
 * @since 1.2.0, 2021-12-10 10:06
 */
public class NC19 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        //1、定义dp数组，确定状态含义,,,以 array[i] 为结尾的「最大子数组和」为 dp[i]。
        // 这个题要注意，很容易定义dp[i]表示：array[0~i]到[i]连续子数组的最大和是dp[i],这样定义是没办法确定状态转移方程的，
        // 因为选择当前数字，并不能保证之前最大和跟当前是连续的。（这就是序列跟子串的区别）
        //参见:https://labuladong.github.io/algo/3/24/76/

        int n = array.length;
        int[] dp = new int[n];

        //3、初始化基础条件
        dp[0] = array[0];

        //2、根据选择，状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
        }

        //返回结果
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;

        //3、初始化基础条件
        int dp0 = array[0];
        int dp1;

        int max = dp0;

        //2、根据选择，状态转移方程
        for (int i = 1; i < n; i++) {
            dp1 = Math.max(dp0 + array[i], array[i]);//当前最大的
            dp0 = dp1;
            max = Math.max(max, dp1);
        }
        return max;
    }
}
