/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.子序列类型;

/**
 * Java_rep: LC72. 编辑距离
 * 看不懂可以参考：https://zhuanlan.zhihu.com/p/105538493
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-30 15:25
 * @since 1.2.0, 2021-11-30 15:25
 */
public class LC72 {

    /**
     * 对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：
     * 以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
     * <p>
     * (1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
     * <p>
     * (2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
     * <p>
     * (3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int s1 = word1.length();
        int s2 = word2.length();


        int[][] dp = new int[s1 + 1][s2 + 1];
        for (int i = 1; i <= s1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= s2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            Math.min(
                                    dp[i][j - 1] + 1,
                                    dp[i - 1][j] + 1
                            ),
                            dp[i - 1][j - 1] + 1
                    );
                }
            }
        }
        return dp[s1][s2];
    }
}
