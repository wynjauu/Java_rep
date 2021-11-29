/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.二叉树;

/**
 * java_20190508: 116. 填充每个节点的下一个右侧节点指针
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-11 23:25
 * @since 1.2.0, 2021-11-11 23:25
 */
public class LC116 {
    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode next;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.next = null;
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
            helper(root.left);
        }
        if (root.right != null) {
            if (root.next == null) {
                root.right.next = null;
            } else {
                root.right.next = root.next.left;
            }
            helper(root.right);
        }

    }
}
