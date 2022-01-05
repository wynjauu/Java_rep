/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

/**
 * Java_rep: NC110 旋转数组
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-18 19:33
 * @since 1.2.0, 2021-12-18 19:33
 */
public class NC110 {
    public int[] solve(int n, int m, int[] a) {
        int k = m % n;
        if (k == 0) {
            return a;
        }
        reverse(a, 0, n - 1);//整体反转
        reverse(a, 0, k - 1);//反转前k个
        reverse(a, k, n - 1);//反转后n-k个
        return a;
    }

    public void reverse(int[] nums, int l, int r) {
        if (null == nums || nums.length == 0) {
            return;
        }
        while (l < r) {
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
    }
}
