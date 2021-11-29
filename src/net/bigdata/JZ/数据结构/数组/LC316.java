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
 * Java_rep: LC316. 去除重复字母
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-27 20:33
 * @since 1.2.0, 2021-11-27 20:33
 */
public class LC316 {

    public String removeDuplicateLetters(String s) {

        int[] count = new int[256]; //利用数组去重使用,因为输入为 ASCII 字符，大小 256
        Stack<Character> stack = new Stack<>();

        //char[] chars = s.toCharArray();
        //1、先统计各个字母出现的次数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }

        //2、利用栈做业务处理
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            count[c]--;// 每遍历过一个字符，都将对应的计数减一
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

        //3、将栈里面的元素转换为数组
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
