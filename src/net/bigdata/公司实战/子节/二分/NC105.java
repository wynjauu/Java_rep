/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.二分;

/**
 * Java_rep: NC105 二分查找-II
 * https://labuladong.github.io/algo/2/21/57/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-16 16:14
 * @since 1.2.0, 2021-12-16 16:14
 */
public class NC105 {
    public static void main(String[] args) {
        int[] arrays = new int[]{5, 7, 7, 8, 8, 10};
        searchRange(arrays, 6);
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        System.out.println(left + "_" + right);

        return new int[]{findLeft(nums, target), findRight(nums, target)};
    }

    public static int findLeft(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid]) {
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static int findRight(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid]) {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }


    public static int findLeft2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid]) {
                right = mid;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static int findRight2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid]) {
                left = mid;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
