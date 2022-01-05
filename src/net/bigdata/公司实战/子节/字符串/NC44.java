/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

/**
 * Java_rep: NC44 通配符匹配
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-14 23:56
 * @since 1.2.0, 2021-12-14 23:56
 */
public class NC44 {

    /**
     * https://leetcode-cn.com/problems/wildcard-matching/comments/
     * ## 思路:
     * <p>
     * **思路一:** 利用两个指针进行遍历。
     * <p>
     * 在代码里解释.
     * <p>
     * 时间复杂度为:$O(mn)$
     * <p>
     * **思路二:** 动态规划
     * <p>
     * dp[i][j]表示s到i位置,p到j位置是否匹配!
     * <p>
     * 初始化:
     * <p>
     * dp[0][0]:什么都没有,所以为true
     * 第一行dp[0][j],换句话说,s为空,与p匹配,所以只要p开始为*才为true
     * 第一列dp[i][0],当然全部为False
     * 动态方程:
     * <p>
     * 如果(s[i] == p[j] || p[j] == "?") && dp[i-1][j-1] ,有dp[i][j] = true
     * <p>
     * 如果p[j] == "*" && (dp[i-1][j] = true || dp[i][j-1] = true) 有dp[i][j] = true
     * <p>
     * ​ note:
     * <p>
     * ​ dp[i-1][j],表示*代表是空字符,例如ab,ab*
     * <p>
     * ​ dp[i][j-1],表示*代表非空任何字符,例如abcd,ab* # 附上自顶向下方法
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        //s以i结尾,p以j结尾能匹配上
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int j = 1; j < pLen + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char c1 = s.charAt(i - 1);
                char c2 = p.charAt(j - 1);
                if (c1 == c2 || c2 == '?') {        //s 与 p 一对一
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2 == '*') {
                    dp[i][j] = dp[i - 1][j - 1]     //因为*可以表示任意字符
                            || dp[i - 1][j]         // 因为*可以表示空字符
                            || dp[i][j - 1];        //因为*可以表示任意字符
                } else {
                    //dp[i][j] = false; 默认boolean类型就是false
                }
            }
        }
        return dp[sLen][pLen];
    }
}
