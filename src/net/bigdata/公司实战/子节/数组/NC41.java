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
 * Java_rep: NC41 最长无重复子数组
 * 这个题不能用动态规划，因为不能确定每次增加一个数在之前是不是出现过，状态转移方程没法写
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-15 14:38
 * @since 1.2.0, 2021-12-15 14:38
 */
public class NC41 {

    public static int maxLength(int[] arr) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;

        int left = 0;
        int len = 0;
        for (int right = 0; right < n; right++) {
            if (list.isEmpty()) {
                list.add(arr[right]);
                len = Math.max(len, list.size());
                continue;
            }
            while (list.contains(arr[right])) {
                list.remove(left);
            }
            list.add(arr[right]);
            len = Math.max(len, list.size());
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 3, 3, 3};
        maxLength(nums);
    }
}
