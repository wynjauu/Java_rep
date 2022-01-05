/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

import java.util.ArrayList;

/**
 * Java_rep: NC121 字符串的排列
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-12 00:42
 * @since 1.2.0, 2021-12-12 00:42
 */
public class NC121 {

    ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        helper(chars, 0);
        return list;
    }

    public void helper(char[] chars, int p) {
        if (p == chars.length - 1) {
            String str = new String(chars);
            if (!list.contains(str)) {
                list.add(str);
            }
        } else {
            for (int i = p; i < chars.length; i++) {
                swap(chars, p, i);
                helper(chars, p + 1);
                swap(chars, i, p);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
