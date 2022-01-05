/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

/**
 * Java_rep: NC113 验证IP地址
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-14 19:07
 * @since 1.2.0, 2021-12-14 19:07
 */
public class NC113 {
    public String solve(String IP) {
        String[] str1 = IP.split("\\.");
        //判断IPV4
        if (str1.length == 4) {
            for (int i = 0; i < str1.length; i++) {
                if (!judge_IPv4(str1[i])) {
                    return "Neither";
                }
            }
            return "IPv4";
        }
        //判断IPV6
        if (str1.length == 8) {
            for (int i = 0; i < str1.length; i++) {
                if (!judge_IPv8(str1[i])) {
                    return "Neither";
                }
            }
            return "IPv6";
        }

        return "Neither";
    }

    public boolean judge_IPv8(String s) {
        if (s.length() > 4) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) || s.startsWith("00")) {
                return false;
            }
        }
        return true;
    }

    public boolean judge_IPv4(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        int num = Integer.parseInt(s);
        if (num > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
