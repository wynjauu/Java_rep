/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.树;

/**
 * java_20190508: LC96. 不同的二叉搜索树
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-18 22:28
 * @since 1.2.0, 2021-11-18 22:28
 */
public class LC96 {
    // 备忘录
    int[][] memo;

    public int numTrees(int n) {
        // 备忘录的值初始化为 0
        memo = new int[n + 1][n + 1];
        return helper(1, n);
    }

    public int helper(int lo, int hi) {
        if (lo > hi) {
            return 1;
        }
        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            int left = helper(lo, i - 1);
            int right = helper(i + 1, hi);
            res = left * right + res;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;
        return res;
    }
}
