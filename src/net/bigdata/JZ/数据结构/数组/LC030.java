/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Java_rep: LC030. 插入、删除和随机访问都是 O(1) 的容器
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-27 11:49
 * @since 1.2.0, 2021-11-27 11:49
 */
public class LC030 {
    /**
     * 数组用来进行等概率的随机访问
     * 哈希表维护数组的值和下标映射
     * 数组的删除: 不能直接把对应位置的元素删除掉,这样以后查找就不是等概率查找了
     * 把x和最后一个数交换(数组和哈希表中都要交换),然后pop最后一个数.
     */
    List<Integer> list; //存储值,底层是数组
    HashMap<Integer, Integer> map; //每个值在list中的位置

    public LC030() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int valMapKey = map.get(val);// 先拿到 val 的索引，也是list中val的位置
        int lastListVal = list.get(list.size() - 1);

        list.set(valMapKey, lastListVal); //此时最后一个元素会覆盖调删除的元素val
        map.put(lastListVal, valMapKey); //更新最后一个元素在hash里面的索引，此时val和list最后一个元素对应的索引位置一样

        list.remove(list.size() - 1);//删除最后一个元素，因为不需要移动数组中的元素，所以是O(1)
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }

    public static void main(String[] args) {
        LC030 lc030 = new LC030();
        lc030.insert(3);
        lc030.insert(4);
        lc030.insert(1);
        lc030.insert(5);

        lc030.remove(4);
    }
}
