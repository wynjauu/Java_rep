/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

/**
 * Java_rep: NC141 判断是否为回文字符串
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-13 14:25
 * @since 1.2.0, 2021-12-13 14:25
 */
public class NC141 {
    public boolean judge(String str) {
        // write code here
        if (str == null || str.length() == 0) {
            return false;
        }

        int len = str.length();

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            char c1 = str.charAt(left);
            char c2 = str.charAt(right);
            if (c1 != c2) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
