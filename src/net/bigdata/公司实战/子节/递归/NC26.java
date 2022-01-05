/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.递归;

import java.util.ArrayList;

/**
 * Java_rep: NC26 括号生成
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-09 23:13
 * @since 1.2.0, 2021-12-09 23:13
 */
public class NC26 {
    /**
     * @param n int整型
     * @return string字符串ArrayList
     */
    ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        generateParenthesis("", 0, 0, n);
        return list;
    }

    public void generateParenthesis(String s, int leftCount, int rightCount, int n) {
        if (leftCount > n || rightCount > n) {
            return;
        }
        if (leftCount == n && rightCount == n) {
            list.add(s);
        }
        if (leftCount >= rightCount) {
            generateParenthesis(s + "(", leftCount + 1, rightCount, n);
            generateParenthesis(s + ")", leftCount, rightCount + 1, n);
        }
    }
}
