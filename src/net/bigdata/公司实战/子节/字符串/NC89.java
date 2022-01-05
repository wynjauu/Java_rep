/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

/**
 * Java_rep: NC89 字符串变形
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-14 00:00
 * @since 1.2.0, 2021-12-14 00:00
 */
public class NC89 {
    public static String trans(String s, int n) {
        // write code here
        if (n == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        helper(stringBuilder, 0, n - 1, true);

        int i = 0;
        int j = 0;
        while (j < n) {
            char c = stringBuilder.charAt(j);
            if (j == n - 1 && c != ' ') {
                helper(stringBuilder, i, j, false);
            }
            if (c == ' ') {
                helper(stringBuilder, i, j - 1, false);
                i = j + 1;
            }
            j++;
        }
        return stringBuilder.toString();
    }

    public static void helper(StringBuilder stringBuilder, int i, int j, boolean trans) {
        while (i <= j) {
            swap(stringBuilder, i, j, trans);
            i++;
            j--;
        }
    }

    public static void swap(StringBuilder stringBuilder, int i, int j, boolean trans) {
        char iT = stringBuilder.charAt(i);
        char jT = stringBuilder.charAt(j);
        if (trans) {
            if ('a' <= iT && iT <= 'z') {
                iT = Character.toUpperCase(iT);
            } else {
                iT = Character.toLowerCase(iT);
            }
            if ('a' <= jT && jT <= 'z') {
                jT = Character.toUpperCase(jT);
            } else {
                jT = Character.toLowerCase(jT);
            }
        }
        stringBuilder.setCharAt(i, jT);
        stringBuilder.setCharAt(j, iT);
    }

    public static void main(String[] args) {
        trans(" h i", 4);
    }
}
