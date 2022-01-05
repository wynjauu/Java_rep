/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.子序列类型;

/**
 * Java_rep: LC583. 两个字符串的删除操作（中等）
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-01 10:51
 * @since 1.2.0, 2021-12-01 10:51
 */
public class LC583 {


    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        //1 、定义dp数组
        int[][] dp = new int[l1 + 1][l2 + 1];

        //3、初始化值    dp[0][0] 表示两个空串，那么base就是0
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            dp[0][j] = j;
        }

        //2 状态转移方程
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, //word1 和 word2 i-1 j-1两个都删
                            Math.min(dp[i - 1][j] + 1, //word1 删除i-1的元素
                                    dp[i][j - 1] + 1));//word2 删除j-1的元素
                }
            }
        }
        return dp[l1][l2];
    }

//    /**
//     * 另一种方式： 借助LC1143.最长公共子序列
//     *
//     * @param word1
//     * @param word2
//     * @return
//     */
//    public int minDistance2(String word1, String word2) {
//        int l1 = word1.length();
//        int l2 = word2.length();
//
//        int helper = helper(word1, word2);
//        return l1 - helper + l2 - helper;
//    }
//
//    public int helper(String word1, String word2) {
//        int l1 = word1.length();
//        int l2 = word2.length();
//
//        //1、定义bp数组，确定含义
//        int[][] dp = new int[l1 + 1][l2 + 1];
//
//        //3、确定初始化值
//
//        //2、定义状态转移方程
//        for (int i = 1; i <= l1; i++) {
//            for (int j = 1; j <= l2; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
//                }
//            }
//        }
//        return dp[l1][l2];
//    }
}
