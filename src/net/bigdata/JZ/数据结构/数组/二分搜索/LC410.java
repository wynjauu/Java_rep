/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组.二分搜索;

/**
 * Java_rep: LC410. 分割数组的最大值
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-26 22:57
 * @since 1.2.0, 2021-11-26 22:57
 */
public class LC410 {
    public int splitArray(int[] nums, int m) {
        int lo = max(nums);  //数据最大值的最小取值应该是数据中最大的一个
        int hi = sum(nums); // 数组最大值的最大取值应该是所有数据之和

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int needM = helper(nums, mid); //当分割数组最大值是mid的时候，分割的数组个数是needM个
            if (needM > m) { //说明mid作为最大值太小了，以至于分了好多数组，因此需要增大mid，将lo变大
                lo = mid + 1;
            } else if (needM < m) { //说明mid作为最大值太大了，以至于分的数据太少了，因此要减小mid，将hi边小
                hi = mid;
            } else {    //说明mid作为最大值的时候，分割的数组个数刚好，这个时候需要找最小的那个lo
                hi = mid;
            }
        }
        return lo;
    }

    private int helper(int[] nums, int x) {
        int count = 0;
        int sum = 0;

        int i = 0;
        while (i < nums.length) {
            if (sum + nums[i] <= x) {
                sum = sum + nums[i];
                i++;
                if (i == nums.length - 1) {
                    count++;
                }
            } else {
                count++;
                sum = 0;
            }
        }
        return count;
    }

    public int max(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }

    public int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        return sum;
    }
}
