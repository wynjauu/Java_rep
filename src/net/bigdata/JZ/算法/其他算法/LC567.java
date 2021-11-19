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
 * 567. 字符串的排列
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-01 22:47
 * @since 1.2.0, 2021-11-01 22:47
 */
public class LC567 {
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {//窗口大小是s1元素个数
                if (valid == need.size()) {//因为need里面保存的是去重的，而valid也是
                    return true;
                }

                char d = s2.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    Integer it = window.get(d);
                    window.put(d, --it);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        checkInclusion("abcdxabcde", "abcdeabcdx");
    }
}
