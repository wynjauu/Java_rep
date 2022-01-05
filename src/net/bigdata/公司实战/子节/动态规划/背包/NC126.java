/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.背包;

import java.util.Arrays;

/**
 * Java_rep: NC126 兑换零钱(一)
 * https://leetcode-cn.com/problems/coin-change/submissions/
 * https://labuladong.github.io/algo/3/23/66/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-21 14:47
 * @since 1.2.0, 2021-12-21 14:47
 */
public class NC126 {
    public int coinChange(int[] arr, int aim) {
        int nums = arr.length;
        int[][] dp = new int[nums + 1][aim + 1];//dp[i][j]代表前i个***的钱加起来为j最少个数
//        for (int i = 0; i < dp.length; i++) {
//            //后面要比较最小值 所以每个dp的初始值都是amount+1 ， 考虑硬币额度全为1用amount枚能换amount额度 amount+1必然是越界值了
//            Arrays.fill(dp[i], aim + 1);
//            if (i > 0) {
//                dp[i][0] = 0; //因为要给dp[1-1]做铺垫 所以dp[0]必须是0
//            }
//        }
        for (int i = 0; i <= nums; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = aim + 1;
        }
        for (int i = 1; i <= nums; i++) {
            for (int j = 1; j <= aim; j++) {
                //别越界 && 至少能换出来才换 && 能换的话 看看我用这枚硬币好 还是不用好
                // && 如果能用硬币你不用的话（或者压根换不出来） 那代价可是MAX值 逼着你尽可能换
                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];//这种只能不放，如果放了就会超过j面值
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], //前i-1个***的钱已经换好j面值了，本次不用加入
                            dp[i][j - arr[i - 1]] + 1); //前i-1个***的钱已经换好j - coins[i - 1]了，加上第i个也刚好
                }
            }
        }
        return dp[nums][aim] == aim + 1 ? -1 : dp[nums][aim];
    }

    /**
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int nums = coins.length;
        //Arrays.sort(coins);
        int[] dp = new int[amount + 1];//dp[i][j]代表前i个***的钱加起来为j最少个数
        //后面要比较最小值 所以每个dp的初始值都是amount+1 ， 考虑硬币额度全为1用amount枚能换amount额度 amount+1必然是越界值了
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;//因为要给dp[1-1]做铺垫 所以dp[0]必须是0
        for (int j = 1; j <= amount; j++) {
            for (int i = 0; i < nums; i++) {
                if (j >= coins[i])
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[][] dp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[i], 99);
            if (i >= 0) {
                dp[i][0] = 0;
            }
        }
        System.out.println(dp);

        int[][] nums = new int[3][3];
        for (int i = 0; i < 3; i++) {
            nums[i][0] = 0;
        }
        for (int j = 1; j < 3; j++) {
            nums[0][j] = 99;
        }
        System.out.println(nums);
    }
}
