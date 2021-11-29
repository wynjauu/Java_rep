/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

import java.util.Stack;

/**
 * Java_rep: LC1081. 不同字符的最小子序列
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-27 21:58
 * @since 1.2.0, 2021-11-27 21:58
 */
public class LC1081 {
    public String smallestSubsequence(String s) {
        int[] count = new int[256];
        Stack<Character> stack = new Stack<>();

        // 1、统计s中每个字符个数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }

        //2、业务逻辑处理
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            count[c]--;

            if (stack.contains(c)) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peek() > c
                    && count[stack.peek()] > 0) {
                stack.pop();
            }

            stack.push(c);
        }

        //  3、解析结果
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }
}
