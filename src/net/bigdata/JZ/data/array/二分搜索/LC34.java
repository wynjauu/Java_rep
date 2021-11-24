/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.data.array.二分搜索;

/**
 * Java_rep: LC34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-24 13:51
 * @since 1.2.0, 2021-11-24 13:51
 */
public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }

    public static int searchLeft(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static int searchRight(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return right < 0 || nums[right] != target ? -1 : right;
    }

    public static void main(String[] args) {
        int i = searchLeft(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.print(i);
    }
}
