/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

import java.util.HashMap;

/**
 * Java_rep: LC1. 两数之和
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-28 14:05
 * @since 1.2.0, 2021-11-28 14:05
 */
public class LC1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); //如果key一样，后一个会覆盖前一个，这不会影响
        }

        for (int j = 0; j < nums.length; j++) {//从前往后循环的，只会找在当前这个数后面的数
            int x = target - nums[j];
            if (map.containsKey(x) && j != map.get(x)) {
                return new int[]{map.get(x), j};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        twoSum(new int[]{3, 3}, 6);
    }
}
