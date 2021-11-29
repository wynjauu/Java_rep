/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Java_rep: LC170.两数之和 III - 数据结构设计（简单）
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-28 14:15
 * @since 1.2.0, 2021-11-28 14:15
 */
public class LC170 {

    // 向数据结构中添加一个数 number
    HashMap<Integer, Integer> map = new HashMap<>();

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    // 寻找当前数据结构中是否存在两个数的和为 value
    public boolean find(int value) {
        for (Integer v : map.keySet()) {
            int x = value - v;
            if (x == v && map.get(x) >= 2) {
                return true;
            }
            if (x != v && map.containsKey(x)) {
                return true;
            }
        }
        return false;
    }


    // 向数据结构中添加一个数 number
    ArrayList<Integer> sums;
    ArrayList<Integer> values = new ArrayList<>();

    public void add2(int number) {
        sums = new ArrayList<>();
        values.add(number);
        for (Integer v : values) {
            sums.add(v + number);
        }
    }

    // 寻找当前数据结构中是否存在两个数的和为 value
    public boolean find2(int value) {
        return sums.contains(value);
    }
}
