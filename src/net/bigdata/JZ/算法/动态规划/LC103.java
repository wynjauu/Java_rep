/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划;

import java.util.Arrays;

/**
 * LC103. 最少的硬币数目
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-24 23:31
 * @since 1.2.0, 2021-10-24 23:31
 */
public class LC103 {

    int dp[];//备忘录

    public int solution(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -666);
        return helper(coins, amount);
    }

    public int helper(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (dp[amount] != -666) {
            return dp[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = solution(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            //在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        dp[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return dp[amount];
    }
}
