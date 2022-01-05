/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

/**
 * Java_rep: NC29 二维数组中的查找
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-18 12:39
 * @since 1.2.0, 2021-12-18 12:39
 */
public class NC29 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array[0].length == 0) {
            return false;
        }
        int m = array.length - 1;
        int n = array[0].length - 1;

        int i = 0;
        int j = n;
        while (i <= m && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                i++;
            }
        }
        return false;
    }
}
