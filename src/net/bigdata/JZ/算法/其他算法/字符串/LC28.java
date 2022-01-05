/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.其他算法.字符串;

/**
 * Java_rep: LC28.实现 strStr(简单)
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-04 21:01
 * @since 1.2.0, 2021-12-04 21:01
 */
public class LC28 {
    public static void getNext(int[] next, String s) {
        //1、初始化
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            //2、前后缀不相同的情况
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            //3、前后缀相同的情况
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            //4、next
            next[i] = j;
        }
        System.out.println(next);
    }


    public static void main(String[] args) {
        String s1 = "aacaaf";
        String s = "aaaaaf";
        getNext(new int[s.length()], s);
        strStr("aacaacaaf", "aacaaf");
    }

    /**
     * 最长相等前后缀：next = [0,1,0,1,2,0]
     *
     * @param haystack =aacaacaaf
     * @param needle   =aacaaf
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }
}
