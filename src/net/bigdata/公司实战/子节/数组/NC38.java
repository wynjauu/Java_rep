/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

import java.util.ArrayList;

/**
 * Java_rep: NC38 螺旋矩阵
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-15 17:06
 * @since 1.2.0, 2021-12-15 17:06
 */
public class NC38 {
    public static ArrayList<Integer> print(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (null == matrix || matrix.length == 0) {
            return list;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int top = 0;
        int left = 0;

        int i = 0;
        int j = 0;
        int lastStep = 0;// 本次走的是哪里？？0 上，1 右，2 下 3 左
        while (top <= m && left <= n) {
            list.add(matrix[i][j]);
            //上
            if (lastStep == 0 && i == top && j <= n) {
                if (j == n) {
                    i++;
                    top++;
                    lastStep = 1;
                } else {
                    j++;
                }
                continue;
            }
            //右
            if (lastStep == 1 && i <= m && j == n) {
                if (i == m) {
                    n--;
                    j--;
                    lastStep = 2;
                } else {
                    i++;
                }
                continue;
            }
            //低
            if (lastStep == 2 && i == m && j >= left) {
                if (j == left) {
                    m--;
                    i--;
                    lastStep = 3;
                } else {
                    j--;
                }
                continue;
            }
            //左
            if (lastStep == 3 && i >= top && j == left) {
                if (i == top) {
                    j++;
                    left++;
                    lastStep = 0;
                } else {
                    i--;
                }
                continue;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        print(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
