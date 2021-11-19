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
 * java_20190508: LC3 无重复字符的最长子串
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-02 22:57
 * @since 1.2.0, 2021-11-02 22:57
 */
public class LC3 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();

        int right = 0;
        int left = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                Integer it = window.get(d);
                window.put(d, --it);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcc");
    }
}
