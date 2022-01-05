/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.背包类型;

/**
 * Java_rep:
 * https://blog.csdn.net/hearthougan/article/details/53869671
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-01 19:03
 * @since 1.2.0, 2021-12-01 19:03
 */
public class Demo {
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int wLen = weight.length;

        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wLen + 1][bagSize + 1];

        //初始化：背包容量为0时，能获得的价值都为0
        // 初始化
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wLen; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; //不放物品i，此时容量为j的价值。。。没放物品i，那么前一个就是i-1,这里之所以j没变，是因为此时求的是容量j的价值dp[i][j]，所以不用变j
                } else { //可以放，但是可以也可以不放
                    dp[i][j] = Math.max( //这两种处理方式去最大值
                            dp[i - 1][j], //有容量放，但是我不放
                            dp[i - 1][j - weight[i - 1]] + value[i - 1]  //已经放了i物品，价值就是：不放物品i容量为为j-weight[i]的价值 加上 物品i的价值
                    );
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] weigth = new int[]{2, 1, 3};
        int[] value = new int[]{4, 2, 3};

        int bagSize = 4;
        testWeightBagProblem(weigth, value, bagSize);

    }
}
