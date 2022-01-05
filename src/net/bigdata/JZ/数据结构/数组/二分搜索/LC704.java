/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组.二分搜索;

/**
 * LC704. 二分查找
 * solution2(new int[]{0, 1, 1, 3, 4, 5, 6, 7}, 2)
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-31 00:09
 * @since 1.2.0, 2021-10-31 00:09
 */
public class LC704 {

    public static int solution(int[] nums, int target) {
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
                return mid;
            }
        }
        return -1;
    }

    public static int solution2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length; //注意
        while (left < right) {//注意
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid]) {
                right = mid; //注意
            }
        }
        return nums[left] == target ? left : -1; //如果是用return left，，solution2(new int[]{0, 1, 1, 3, 4, 5, 6, 7}, 2)返回的是3
    }

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 2));//2
        System.out.println(solution2(new int[]{0, 1, 1, 3, 4, 5, 6, 7}, 2));//3
    }
}
