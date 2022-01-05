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
 * Java_rep: NC73 数组中出现次数超过一半的数字
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-15 22:57
 * @since 1.2.0, 2021-12-15 22:57
 */
public class NC73 {
    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = array.length;
        for (int i = 0; i < n; i++) {
            int num = array[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }
}
