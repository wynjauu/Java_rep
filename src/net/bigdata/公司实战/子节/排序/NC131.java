/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.排序;

import java.util.*;

/**
 * Java_rep: NC131 数据流中的中位数
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-19 18:09
 * @since 1.2.0, 2021-12-19 18:09
 */
public class NC131 {
    ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        list.sort((o1, o2) -> o1 - o2);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            left++;
            right--;
        }
        if (left == right) {
            return (double) list.get(left);
        } else {
            return (double) (list.get(left) + list.get(right)) / 2;
        }
    }
}
