/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

/**
 * Java_rep: LC27. 移除元素
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-27 23:25
 * @since 1.2.0, 2021-11-27 23:25
 */
public class LC27 {
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

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 3, 4};

        //1134  1434
        int i = removeElement(nums, 3);
        System.out.print(i);
    }
}
