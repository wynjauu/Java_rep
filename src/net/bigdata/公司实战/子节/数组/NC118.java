/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

import java.util.Arrays;

/**
 * Java_rep: NC118 数组中的逆序对
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-18 12:45
 * @since 1.2.0, 2021-12-18 12:45
 */
public class NC118 {

    /**
     * @param nums
     * @return
     */
    static int count = 0;

    public int InversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
        return count;
    }

    public static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int i = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                temp[i++] = nums[l++];
            } else if (nums[l] > nums[r]) {//此时当前这个l的元素，肯定大于右边r（包括r）之前的所有元素
                //逆序对数为i到mid，个数为mid-i+1
                //是从array[i]开始比较的，所以起点为i
                //注意的是：每次加完mid-i+1后，都要对1000000007取模
                count = (count + mid - l + 1) % 1000000007;
                temp[i++] = nums[r++];
            }
        }

        while (l <= mid) {
            temp[i++] = nums[l++];
        }
        while (r <= right) {
            temp[i++] = nums[r++];
        }
        i = 0;
        while (left <= right) {
            nums[left++] = temp[i++];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{364, 637, 341, 406};//"这里会有重复的累计" 的案例
        int[] nums2 = new int[]{4, 5, 1, 2};//"count = count + r-mid;有问题,会导致当r一直加的时候，累计会重复，前面累加了的又累加了" 的案例
        int[] nums3 = new int[]{7, 5, 6, 4};

        int[] temp = new int[nums.length];
        sort(nums3, 0, nums.length - 1, temp);
        System.out.println(count);
    }
}
