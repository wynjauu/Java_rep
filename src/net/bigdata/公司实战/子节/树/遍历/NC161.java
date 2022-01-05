/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.遍历;

import java.util.LinkedList;

/**
 * Java_rep: NC161 二叉树的中序遍历
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-09 13:52
 * @since 1.2.0, 2021-12-09 13:52
 */
public class NC161 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int[] inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        helper(root, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void helper(TreeNode root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
