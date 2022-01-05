/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.二分;

/**
 * Java_rep: NC86 矩阵元素查找
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-19 18:57
 * @since 1.2.0, 2021-12-19 18:57
 */
public class NC86 {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int[] res = new int[2];
        if (mat == null || mat[0].length == 0) {
            return res;
        }
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                res[0] = i;
                res[1] = j;
                return res;
            } else if (mat[i][j] > x) {
                j--;
            } else if (mat[i][j] < x) {
                i++;
            }
        }
        return res;
    }
}
