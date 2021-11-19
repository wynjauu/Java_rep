/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.JZ.数据结构.树;

/**
 * java_20190508: LC538. 把二叉搜索树转换为累加树
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-15 00:10
 * @since 1.2.0, 2021-11-15 00:10
 */
public class LC538 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    int sum = 0;

    public void helper(TreeNode root) {
        if (null == root) {
            return;
        }
        helper(root.right);
        sum = sum + root.val;
        root.val = sum;
        helper(root.left);
    }
}
