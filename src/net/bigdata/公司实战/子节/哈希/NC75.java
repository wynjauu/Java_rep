/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.哈希;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Java_rep: NC75 数组中只出现一次的两个数字
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-20 23:54
 * @since 1.2.0, 2021-12-20 23:54
 */
public class NC75 {
    public int[] FindNumsAppearOnce(int[] array) {
        // write code here
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.remove(num);
            }
        }
        //ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        //Collections.sort(list,(o1,o2)->o1.getKey()-o2.getKey());
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[i++] = entry.getKey();
        }
        Arrays.sort(res);
        return res;
    }
}
