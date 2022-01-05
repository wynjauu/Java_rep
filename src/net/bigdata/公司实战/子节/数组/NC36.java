/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

/**
 * Java_rep: NC36 在两个长度相等的排序数组中找到上中位数
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-16 10:20
 * @since 1.2.0, 2021-12-16 10:20
 */
public class NC36 {
    public static int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        // write code here
        if ((arr1 == null || arr1.length == 0)
                && (arr2 == null || arr2.length == 0)) {
            return 0;
        }
        if (arr1 == null || arr1.length == 0) {
            return arr2[arr2.length / 2];
        }
        if (arr2 == null || arr2.length == 0) {
            return arr1[arr1.length / 2];
        }

        int m = arr1.length;
        int n = arr2.length;

        int target = (m + n) / 2;
        int p = 0;

        int a1 = 1;
        int a2 = 1;

        while (true) {
            if (arr1[a1 - 1] <= arr2[a2 - 1]) {
                p++;
                if (p == target) {
                    return arr1[a1 - 1];
                }
                a1++;
            } else {
                p++;
                if (p == target) {
                    return arr2[a2 - 1];
                }
                a2++;
            }
        }
    }

    public static void main(String[] args) {
        findMedianinTwoSortedAray(new int[]{1, 2}, new int[]{3, 4});
    }
}
