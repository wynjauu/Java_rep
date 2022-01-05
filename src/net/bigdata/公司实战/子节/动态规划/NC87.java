/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划;

/**
 * Java_rep: NC87 丢棋子问题
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-21 17:16
 * @since 1.2.0, 2021-12-21 17:16
 */
public class NC87 {
    public int solve(int N, int K) {
        int[][] dp = new int[K + 1][N + 1]; // dp[i][j] i 个鸡蛋扔 j 次能确定的最大区间的层数
        for (int j = 1; j <= N; j++) {
            dp[0][j] = 0;
            for (int i = 1; i <= K; i++) {
                // 如果碎了，确定 F 在碎的层数下面，即确定层数区间是 dp[i - 1][j - 1]
                // 如果没碎，确定 F 在扔的那一层 或者 扔的层数上面，即 1 + dp[i][j - 1]
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + 1;
                if (dp[i][j] >= N) {
                    return j;
                }
            }
        }
        return N;
    }
}
