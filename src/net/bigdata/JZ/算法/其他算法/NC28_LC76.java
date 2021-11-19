/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.其他算法;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-31 16:28
 * @since 1.2.0, 2021-10-31 16:28
 */
public class NC28_LC76 {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {

            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;

            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;

                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    Integer integer = window.get(d);
                    window.put(d, --integer);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("EBBANCF", "ABBC"));
    }
}
