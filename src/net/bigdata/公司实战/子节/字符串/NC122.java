/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

/**
 * Java_rep: NC122 正则表达式匹配
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-15 13:35
 * @since 1.2.0, 2021-12-15 13:35
 */
public class NC122 {

    public boolean match(String str, String pattern) {
        int sLen = str.length();
        int pLen = pattern.length();

        boolean[][] dp = new boolean[sLen + 1][pLen];

        //特判有一方为空的情况
        dp[0][0] = true;
        for (int j = 1; j <= pLen; j++) {
            if (j == 1 && pattern.charAt(j - 1) == '*') {//也就是也就是patern=*  才能是true
                dp[0][1] = true;
            } else if (j == 2 && pattern.charAt(j - 1) == '*') { //也就是patern=[任意符号]*  才能是true
                dp[0][2] = true;
            } else if (pattern.charAt(j - 1) == '*') { //也就是patern=[任意符号]******  才能是true
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < pLen + 1; j++) {
                char c1 = str.charAt(i - 1);
                char c2 = pattern.charAt(j - 1);
                if (c1 == c2 || c2 == '.') { //. 表示任意字符
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2 == '*') {
                    //考虑 x* 子结构，如果 x 能够匹配，则有0次，1次和多次的情况
                    if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == c1) {

                    }
                }
            }
        }
        return false;
    }
}
