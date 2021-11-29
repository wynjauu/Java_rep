/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

/**
 * Java_rep: LC283. 移动零
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-27 23:44
 * @since 1.2.0, 2021-11-27 23:44
 */
public class LC283 {

    public void moveZeroes(int[] nums) {
        int p = removeElement(nums, 0);
        while (p < nums.length) {
            nums[p] = 0;
            p++;
        }
    }

    public static int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
