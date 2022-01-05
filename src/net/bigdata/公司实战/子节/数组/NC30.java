/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Java_rep: NC30 缺失的第一个正整数
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-16 11:31
 * @since 1.2.0, 2021-12-16 11:31
 */
public class NC30 {

    public int minNumberDisappeared(int[] nums) {
        // write code here
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int flag = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] == flag) {
                flag++;
            }
        }
        return flag;
    }

//    public int minNumberDisappeared2(int[] nums) {
//        // write code here
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//        int i = 1;
//        while (!set.isEmpty()) {
//            if (!set.contains(i)) {
//                return i;
//            }
//            i++;
//        }
//        return i;
//    }
}
