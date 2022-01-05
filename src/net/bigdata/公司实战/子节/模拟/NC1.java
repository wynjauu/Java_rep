/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.模拟;

/**
 * Java_rep: NC1 大数加法
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-20 19:08
 * @since 1.2.0, 2021-12-20 19:08
 */
public class NC1 {
    public String solve(String s, String t) {
        if (s == null || s.length() == 0) {
            return t;
        }
        if (t == null || t.length() == 0) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int sum = 0;
        int i = s.length() - 1;
        int j = t.length() - 1;
        while (i >= 0 || j >= 0) {

            if (i >= 0) {
                int s1 = s.charAt(i) - '0';
                i--;
                sum = sum + s1;
            }
            if (j >= 0) {
                int t1 = t.charAt(j) - '0';
                j--;
                sum = sum + t1;
            }
            stringBuilder.append(sum % 10);
            sum = sum / 10;
        }

        if (sum > 0) {
            stringBuilder.append(sum);
        }
        return stringBuilder.reverse().toString();
    }
}
