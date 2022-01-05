/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.回文;

/**
 * Java_rep: LC5. 最长回文子串
 * https://labuladong.github.io/algo/4/32/134/
 * 回文串就是正着读和反着读都一样的字符串
 * 寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串
 * 核心是双指针
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-05 17:27
 * @since 1.2.0, 2021-12-05 17:27
 */
public class LC5 {
    public static String longestPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String res1 = helper(s, i, i);  // 以 s[i] 为中心的最长回文子串
            String res2 = helper(s, i, i + 1); // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            if (res1.length() > result.length()) {
                result = res1;
            }
            if (res2.length() > result.length()) {
                result = res2;
            }
        }
        return result;
    }

    public static String helper(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
