/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

/**
 * Java_rep: NC18 顺时针旋转矩阵
 * 先按主对角线翻转，再左右翻转
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-16 12:02
 * @since 1.2.0, 2021-12-16 12:02
 */

public class NC18 {

    /**
     * //先按主对角线翻转，再左右翻转
     *
     * @param mat
     * @param n
     * @return
     */
    public int[][] rotateMatrix(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = mat[i][j];
                mat[i][j] = temp;
            }
        }
        return mat;
    }
}
