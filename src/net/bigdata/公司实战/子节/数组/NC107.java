/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

/**
 * Java_rep: NC107 寻找峰值
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-18 11:43
 * @since 1.2.0, 2021-12-18 11:43
 */
public class NC107 {

    /**
     * https://leetcode-cn.com/problems/find-peak-element/comments/
     * 为什么二分查找大的那一半一定会有峰值呢？（即nums[mid]<nums[mid+1]时，mid+1~N一定存在峰值）
     * 我的理解是，首先已知 nums[mid+1]>nums[mid]，那么mid+2只有两种可能，一个是大于mid+1，一个是小于mid+1，小于mid+1的情况，那么mid+1就是峰值，大于mid+1的情况，继续向右推，如果一直到数组的末尾都是大于的，那么可以肯定最后一个元素是峰值，因为nums[nums.length]=负无穷
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int n = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                if (mid + 1 == n) {
                    return mid + 1;
                }
                if (mid + 2 <= n && nums[mid + 1] > nums[mid + 2]) {
                    return mid + 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > nums[mid + 1]) {
                if (mid == 0) {
                    return mid;
                }
                if (nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
