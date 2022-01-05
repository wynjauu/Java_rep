/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串.大数;

/**
 * Java_rep: NC1 大数加法
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-11 22:06
 * @since 1.2.0, 2021-12-11 22:06
 */
public class NC1 {
    public static String solve(String s, String t) {
        // write code here
        int s1 = s.length() - 1;
        int t1 = t.length() - 1;
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        while (s1 >= 0 || t1 >= 0) {
            int sum = temp;
            if (s1 >= 0) {
                sum += Integer.parseInt(String.valueOf(s.charAt(s1--) - '0'));
            }
            if (t1 >= 0) {
                sum += Integer.parseInt(String.valueOf(t.charAt(t1--) - '0'));
            }
            temp = sum / 10;
            sb.append(sum % 10);
        }
        if (temp > 0) {
            sb.append(temp);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "56";
        String t = "78";
        solve(s, t);
    }
}
