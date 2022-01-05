/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.dfs;

/**
 * Java_rep: NC138 矩阵最长递增路径
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-22 17:47
 * @since 1.2.0, 2021-12-22 17:47
 */
public class NC138 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 递增路径的最大长度
     *
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    int max = 0;

    public int solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //因为递增路径可以向四个方向移动，因此必须向四个方向进行dfs遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {//因为是求递增路径，所以每个元素都得计算以它为起点的路径长度
                dfs(matrix, i, j, -1, 0);//初始之前的是-1（即任意元素都比他大），长度是0
            }
        }
        return max;
    }

    //pre表示上一个格子的数字，len是上一个格子的最大长度
    public void dfs(int[][] matrix, int i, int j, int pre, int len) {
        //设置递归结束条件
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            max = Math.max(max, len);
            return;
        }
        if (matrix[i][j] <= pre) {//已经找到了一条路径
            max = Math.max(max, len);
            return;
        }
        //向四个方向扩展
        dfs(matrix, i - 1, j, matrix[i][j], len + 1);
        dfs(matrix, i + 1, j, matrix[i][j], len + 1);
        dfs(matrix, i, j - 1, matrix[i][j], len + 1);
        dfs(matrix, i, j + 1, matrix[i][j], len + 1);
    }
}
