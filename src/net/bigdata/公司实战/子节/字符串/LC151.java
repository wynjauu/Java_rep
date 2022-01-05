/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

/**
 * Java_rep: 151. 翻转字符串里的单词
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-11 19:48
 * @since 1.2.0, 2021-12-11 19:48
 */
public class LC151 {
    public static String reverseWords(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }

        //空格处理
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || (stringBuilder.length() > 0
                    && stringBuilder.charAt(stringBuilder.length() - 1) != ' ')) {
                stringBuilder.append(c);
            }
            start++;
        }

        //先整体反转
        int left = 0;
        int right = stringBuilder.length();
        helper(stringBuilder, left, right - 1);

        //局部反转
        int l = 0;
        for (int i = 0; i <= stringBuilder.length(); i++) {
            if (i == stringBuilder.length()) {
                helper(stringBuilder, l, i - 1);
                break;
            }
            if (stringBuilder.charAt(i) == ' ') {
                helper(stringBuilder, l, i - 1);
//                while (stringBuilder.charAt(i) == ' ') {
//                    i += 1;
//                }
//                l = i;
                l = i + 1;
            }
        }
        return stringBuilder.toString();
    }


    public static void helper(StringBuilder chars, int left, int right) {
        while (left <= right) {
            swap(chars, left, right);
            left++;
            right--;
        }
    }

    public static void swap(StringBuilder chars, int left, int right) {
        char temp = chars.charAt(left);
        chars.setCharAt(left, chars.charAt(right));
        chars.setCharAt(right, temp);
    }


    public static void main(String[] args) {
        String s = "  a good   e";
        System.out.println(reverseWords(s));
    }
}
