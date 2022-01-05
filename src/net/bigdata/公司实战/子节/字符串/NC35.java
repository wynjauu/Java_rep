/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

/**
 * Java_rep: NC35 编辑距离(二)
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-13 18:52
 * @since 1.2.0, 2021-12-13 18:52
 */
public class NC35 {
    public int editMin(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        int s1 = str1.length();
        int s2 = str2.length();

        //str1 0~i   与   st2 0~j 的最小编辑距离
        int[][] dp = new int[s1 + 1][s2 + 1];
        for (int i = 0; i <= s1; i++) {
            dp[i][0] = i * dc;  //需要删除,这里j=0表示str2是一个空的字符串
        }

        for (int j = 0; j <= s2; j++) {
            dp[0][j] = j * ic;  //需要插入,这里i=0表示str1是一个空的字符串
        }

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(
                            dp[i][j - 1] + 1 * ic, //插入
                            dp[i - 1][j] + 1 * dc //删除
                    ), dp[i - 1][j - 1] + 1 * rc);//替换
                }
            }
        }
        return dp[s1][s2];
    }
}
