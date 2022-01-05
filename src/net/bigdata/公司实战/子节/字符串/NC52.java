/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

import java.util.Stack;

/**
 * Java_rep: NC52 有效括号序列
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-11 21:55
 * @since 1.2.0, 2021-12-11 21:55
 */
public class NC52 {

    public boolean isValid(String s) {
        // write code here
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char c1 = stack.peek();
                if ((c1 == '(' && c != ')')
                        || (c1 == ')' && c != '(')
                        || (c1 == '[' && c != ']')
                        || (c1 == ']' && c != '[')
                        || (c1 == '{' && c != '}')
                        || (c1 == '}' && c != '{')
                ) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
