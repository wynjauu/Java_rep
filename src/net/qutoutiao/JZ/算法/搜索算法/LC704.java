/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.JZ.算法.搜索算法;

/**
 * 704. 二分查找
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-31 00:09
 * @since 1.2.0, 2021-10-31 00:09
 */
public class LC704 {

    public int solution(int[] nums, int target) {
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
            } else {
                return mid;
            }
        }
        return -1;
    }
}
