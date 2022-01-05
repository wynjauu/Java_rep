/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划;

/**
 * Java_rep: NC59 矩阵的最小路径和
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 13:10
 * @since 1.2.0, 2021-12-06 13:10
 */
public class NC59 {
    /**
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum(int[][] matrix) {
        // write code here
        if (null == matrix || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        //1、定义dp数组，确定状态和选择的含义
        int[][] dp = new int[n][m];

        //3、初始化基础条件
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        //2、状态转移方程的逻辑
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + matrix[i][j], dp[i][j - 1] + matrix[i][j]);
            }
        }
        return dp[n - 1][m - 1];
    }
}
