/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.堆;

/**
 * Java_rep: NC88 寻找第K大
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-20 20:06
 * @since 1.2.0, 2021-12-20 20:06
 */
public class NC88 {

    public static int findKth(int[] a, int n, int K) {
        // write code here
        return quick(a, 0, n - 1, K);
    }

    public static int quick(int[] nums, int left, int right, int k) {
        int pos = partition(nums, left, right); // 划分函数处理
        if (pos > nums.length - k) {
            return quick(nums, left, pos - 1, k);
        } else if (pos < nums.length - k) {
            return quick(nums, pos + 1, right, k);
        } else {
            return nums[pos];
        }
    }

    public static int partition(int[] a, int left, int right) {
        int l = left;
        int r = right;

        int x = a[l];
        while (l < r) {
            while (l < r && a[r] > x) {
                r--;
            }
            if (l < r) {
                a[l++] = a[r];
            }
            while (l < r && a[l] < x) {
                l++;
            }
            if (l < r) {
                a[r--] = a[l];
            }
        }
        a[l] = x;
        return l;
    }

    public static void main(String[] args) {
        System.out.println(findKth(new int[]{1, 3, 5, 2, 2}, 5, 2));
    }
}
