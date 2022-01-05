/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.哈希;

import java.util.*;

/**
 * Java_rep: NC97 字符串出现次数的TopK问题
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-20 22:42
 * @since 1.2.0, 2021-12-20 22:42
 */
public class NC97 {
    public static String[][] topKstrings(String[] strings, int k) {
        // write code here
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> key : map.entrySet()) {
            //TODO
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue().compareTo(o2.getValue()) == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            res[i][0] = list.get(i).getKey();
            res[i][1] = String.valueOf(list.get(i).getValue());
        }
        return res;
    }

//    public static void sort(String[] strings, int left, int right, String[] temp) {
//        if (left < right) {
//            int mid = (right + left) / 2;
//            sort(strings, left, mid, temp);
//            sort(strings, mid + 1, right, temp);
//            merge(strings, left, mid, right, temp);
//        }
//    }
//
//    public static void merge(String[] strings, int left, int mid, int right, String[] temp) {
//        if (left < right) {
//            int l = left;
//            int r = mid + 1;
//            int i = 0;
//            while (l <= mid && r <= right) {
//                if (strings[r].compareTo(strings[l]) > 0) {
//                    temp[i++] = strings[l++];
//                } else {
//                    temp[i++] = strings[r++];
//                }
//            }
//
//            while (l <= mid) {
//                temp[i++] = strings[l++];
//            }
//            while (r <= right) {
//                temp[i++] = strings[r++];
//            }
//
//            i = 0;
//            while (left <= right) {
//                strings[left++] = temp[i++];
//            }
//        }
//    }
}
