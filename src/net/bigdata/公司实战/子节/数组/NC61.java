/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

import java.util.HashMap;

/**
 * Java_rep: NC61 两数之和
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-15 14:17
 * @since 1.2.0, 2021-12-15 14:17
 */
public class NC61 {

    public int[] twoSum(int[] numbers, int target) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = numbers.length;
        for (int i = 0; i < l; i++) {
            int num = numbers[i];
            int num2 = target - num;
            if (map.containsKey(num2)) {
                return new int[]{map.get(num2), i + 1};
            } else {
                map.put(num, i + 1);
            }
        }
        return new int[0];
    }
}
