/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.递归;

/**
 * Java_rep: NC68 跳台阶
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-09 14:20
 * @since 1.2.0, 2021-12-09 14:20
 */
public class NC68 {
    /**
     * 递归
     *
     * @param target
     * @return
     */
    public int jumpFloor(int target) {
        if (target <= 3) {
            return target;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    /**
     * 动态规划
     */
    public static int jumpFloor1(int target) {

        if (target <= 2) {
            return target;
        }
        //1、定义dp数组，确定状态含义
        int dp[] = new int[target + 1];

        //2、初始化初始条件
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        //3、状态转移方程
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        jumpFloor1(2);
    }
}
