/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划;

/**
 * Java_rep: NC35 编辑距离(二)
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-11 15:19
 * @since 1.2.0, 2021-12-11 15:19
 */
public class NC35 {

    /**
     * 摘自力扣评论：
     * 对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：
     * 以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
     * <p>
     * (1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
     * <p>
     * (2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
     * <p>
     * (3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
     *
     * @param str1
     * @param str2
     * @param ic
     * @param dc
     * @param rc
     * @return
     */
    public int minEditCost(String str1, String str2, int ic, int dc, int rc) {

        if ((null == str1 && null == str2)) {
            return 0;
        }

        int s1 = str1.length();
        int s2 = str2.length();

        //想清楚状态矩阵的定义，下标代表长度！！
        int[][] dp = new int[s1 + 1][s2 + 1];

        //注意i =0 j=0的分别表示str1 str2为""空，这边不要定义 i < s1,j<s2,不然，初始化的时候不容易做
        for (int i = 0; i <= s1; i++) {
            dp[i][0] = i * dc;//str1所有字符全部删除变成str2
        }

        for (int j = 0; j <= s2; j++) {
            dp[0][j] = j * ic;//空字符串str1全部插入变成str2
        }
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                char c1 = str1.charAt(i - 1);
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //等价于str1的前i个字符和str2的前j-1个字符编辑距离的子问题。
                    //即对于str2的第j个字符'X'，我们在str1的末尾添加了一个相同的字符'X'，
                    //那么dp[i][j]最小可以为dp[i][j-1]+ic；
                    int insert = dp[i][j - 1] + ic;//插入

                    //等价于str1的前i-1个字符和str2的前j个字符编辑距离的子问题。
                    //即对于str1的第i个字符'X'，我们在str2的末尾添加了一个相同的字符'X'，等价于在str1的末尾删除了该字符'X'，
                    //那么dp[i][j]最小可以为dp[i][j-1]+dc；
                    int delete = dp[i - 1][j] + dc;//删除

                    //等价于str1的前i-1个字符和str2的前j-1个字符编辑距离的子问题。
                    //即对于str1的第i个字符'X'，对于str2的第j个字符'W'，我们在str1的末尾'X'替换为字符'W'，
                    //那么dp[i][j]最小可以为dp[i-1][j-1]+rc；
                    int replace = dp[i - 1][j - 1] + rc; //替换
                    dp[i][j] = Math.min(Math.min(insert, delete), replace);
                }
            }
        }
        return dp[s1][s2];
    }
}
