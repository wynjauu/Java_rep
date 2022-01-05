/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.排序;

/**
 * Java_rep: NC111 最大数
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-19 16:13
 * @since 1.2.0, 2021-12-19 16:13
 */
public class NC111 {
    public String solve(int[] nums) {
        // write code here
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] + "";
        }
        sort(arr, 0, arr.length - 1);
        if (arr[0].equals("0")) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }

    public void sort(String[] nums, int left, int right) {
        if (left < right) {
            int l = left;
            int r = right;
            String x = nums[l];
            while (l < r) {
                while (l < r && (x + nums[r]).compareTo(nums[r] + x) > 0) { //说明nums[l]应该排后面
                    r--;
                }
                if (l < r) {
                    nums[l++] = nums[r];
                }
                while (l < r && (nums[l] + x).compareTo(x + nums[l]) > 0) {
                    l++;
                }
                if (l < r) {
                    nums[r--] = nums[l];
                }
            }
            nums[l] = x;
            sort(nums, left, l - 1);
            sort(nums, l + 1, right);
        }
    }
}
