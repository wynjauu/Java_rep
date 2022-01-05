/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划;

import java.util.Arrays;

/**
 * Java_rep: LC931. 下降路径最小和
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-29 15:11
 * @since 1.2.0, 2021-11-29 15:11
 */
public class LC931 {
    int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return 0;
        }
        memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            min = Math.min(min, dp(matrix, matrix.length - 1, j));
        }
        return min;
    }

    public int dp(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length
                || j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == 0) {
            return matrix[0][j];
        }
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }
        int min = Math.min(Math.min(dp(matrix, i - 1, j), dp(matrix, i - 1, j - 1)), dp(matrix, i - 1, j + 1)) + matrix[i][j];
        memo[i][j] = min;
        return memo[i][j];
    }
}
