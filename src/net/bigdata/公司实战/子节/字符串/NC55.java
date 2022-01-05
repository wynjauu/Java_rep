/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

/**
 * Java_rep: NC55 最长公共前缀
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-13 23:38
 * @since 1.2.0, 2021-12-13 23:38
 */
public class NC55 {

    public String commonHead(String[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return "";
        }
        String first = arrays[0];
        if (arrays.length == 1) {
            return first;
        }
        int n = first.length();
        for (int i = 0; i < arrays.length; i++) {
            while (!arrays[i].startsWith(first.substring(0, n))) {
                n--;
            }
        }
        return first.substring(0, n);
    }
}
