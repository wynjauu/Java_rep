/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.子序列类型;

import java.util.Arrays;

/**
 * Java_rep: LC300. 最长递增子序列
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-29 10:51
 * @since 1.2.0, 2021-11-29 10:51
 */
public class LC300 {

    public static int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        //第一步：定义 dp 数组（定义数组元素的含义）
        int[] dp = new int[nums.length];//dp[i] 表示以nums[i]结尾的最大子序列的长度（所以子序列一定是是以nums[i]结尾）

        //第二步：确定base case（找出初始值）
        Arrays.fill(dp, 1);//每个数的最大子序列最少是1，就是自己本身，

        //第三步：定义状态转移方程（找出数组元素之间的关系式）
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);//注意：这里因为j从0一直循环到i-1,dp[i]的值一直在修改，所以每次需要比较前一个比较更改的dp[i]值和当前dp[j] + 1
                } else {
                    //dp[i] = Math.max(1, dp[i]); //因为dp[i]的含义是以arr[i]结尾的子序列，子序列必须是以arr[i]结尾.这边因为可能1覆盖dp[i],所以要求max
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = lengthOfLIS(new int[]{1, 3, 2, 3});
        System.out.println("dddd" + i);
    }
}
