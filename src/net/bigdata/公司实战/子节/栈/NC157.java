/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.栈;

import java.util.Stack;

/**
 * Java_rep: NC157 单调栈
 * https://labuladong.github.io/algo/2/20/48/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-21 00:53
 * @since 1.2.0, 2021-12-21 00:53
 */
public class NC157 {
    public int[][] foundMonotoneStack(int[] nums) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int[][] res = new int[nums.length][2];

        int n = nums.length;

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            res[i][1] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            stack.pop();
        }
        for (int i = 0; i <= n - 1; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            res[i][0] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }
}
