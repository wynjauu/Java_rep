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
 * Java_rep: NC90 包含min函数的栈
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-21 00:59
 * @since 1.2.0, 2021-12-21 00:59
 */
public class NC90 {
    private Stack<Integer> stack = new Stack<Integer>();
    int MIN = Integer.MAX_VALUE;

    public void push(int node) {
        stack.push(MIN);
        if (node < MIN) MIN = node;
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        MIN = stack.peek();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return MIN;
    }
}
