/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划;

/**
 * Java_rep: LC64.最小路径和（中等）
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-02 20:01
 * @since 1.2.0, 2021-12-02 20:01
 */
public class LC64 {

    public int minPathSum(int[][] grid) {
        if (null == grid || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        //1、定义dp数组
        int[][] dp = new int[m][n];

        //3 初始值
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        //2、状态转移方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
