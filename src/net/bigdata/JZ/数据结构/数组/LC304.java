/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

/**
 * java_20190508: LC304. 二维区域和检索 - 矩阵不可变
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-20 22:01
 * @since 1.2.0, 2021-11-20 22:01
 */
public class LC304 {

    int[][] preNums;

    public LC304(int[][] matrix) {
        int xL = matrix.length;
        int yL = matrix[0].length;
        preNums = new int[xL + 1][yL + 1];

        for (int x = 1; x <= xL; x++) {
            for (int y = 1; y <= yL; y++) {
                preNums[x][y] = preNums[x - 1][y] + preNums[x][y - 1] + matrix[x - 1][y - 1] - preNums[x - 1][y - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preNums[row2 + 1][col2 + 1] - preNums[row1][col2 + 1] - preNums[row2 + 1][col1] + preNums[row1][col1];
    }
}
