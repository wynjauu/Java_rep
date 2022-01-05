/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.递归;

import java.util.Stack;

/**
 * Java_rep: NC137 表达式求值
 * http://www.manongjc.com/detail/25-foxphgrkewjlydn.html
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-09 20:31
 * @since 1.2.0, 2021-12-09 20:31
 */
public class NC137 {

    public static void main(String[] args) {
        String s = "-100*10";
        System.out.println(solve(s));
    }

    public static int solve(String s) {
        // write code here
        int res = 0;
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        char op = '+'; //默认第一次的操作是+号
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                sum = sum * 10 + c - '0';
            } else if (c == '(') {
                //递归处理有括号的情况
                int cnt = 0;
                int j = i;
                for (; i < n; i++) {
                    c = s.charAt(i);
                    if (c == '(') {
                        cnt++;
                    }
                    if (c == ')') {
                        cnt--;
                    }
                    if (cnt == 0) {
                        break;
                    }
                }
                sum = solve(s.substring(j + 1, i));
                i--;
            }

            //如果遍历到了（+-*/）或者到了n-1最后
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1) {
                if (op == '+') {
                    stack.push(sum);
                } else if (op == '-') {
                    stack.push(-sum);
                } else if (op == '*') {
                    int t = sum * stack.pop();
                    stack.push(t);
                } else if (op == '/') {
                    int t = sum / stack.pop();
                    stack.push(t);
                }
                op = c;
                sum = 0;
            }
        }
        while (!stack.isEmpty()) {
            res = res + stack.pop();
        }
        return res;
    }

}
