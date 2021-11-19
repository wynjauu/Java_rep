/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.JZ.算法.其他算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-01 23:29
 * @since 1.2.0, 2021-11-01 23:29
 */
public class LC438 {
    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);

        }

        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> result = new ArrayList<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) { //这里之所以用p.length()是因为窗口大小元素个数是固定的（left 缩小窗口的时机是窗口大小大于 p.length() 时，应为排列嘛，显然长度应该是一样的）
                if (valid == need.size()) {//这里之所以用valid == need.size() 是因为valid 后面会有去重--
                    result.add(left);
                }
                char d = s.charAt(left);
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
        return result;
    }

    public static void main(String[] args) {
        findAnagrams("baa", "aa");
    }
}
