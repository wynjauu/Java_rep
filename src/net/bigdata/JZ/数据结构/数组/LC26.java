/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

/**
 * Java_rep: LC26. 删除有序数组中的重复项
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-27 22:41
 * @since 1.2.0, 2021-11-27 22:41
 */
public class LC26 {
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            int fastVal = nums[fast];
            int slowVal = nums[slow];
            if (fastVal != slowVal) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
