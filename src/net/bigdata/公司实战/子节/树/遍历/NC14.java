/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.遍历;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Java_rep: NC14 按之字形顺序打印二叉树
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 15:14
 * @since 1.2.0, 2021-12-07 15:14
 */
public class NC14 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        helper(pRoot);
        return result;
    }

    public void helper(TreeNode pRoot) {
        if (null == pRoot) {
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();//s1存奇数层节点
        Stack<TreeNode> s2 = new Stack<>();//s2存偶数层节点
        s1.push(pRoot);

        int flag = 1;

        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            if (flag % 2 != 0) {
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (null != node) {
                        list.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
            } else {
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (null != node) {
                        list.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
            }
            if (!list.isEmpty()) {
                result.add(list);
                flag++;
            }
        }
    }
}
