/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.二叉树;

/**
 * java_20190508: LC450. 删除二叉搜索树中的节点
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-15 23:36
 * @since 1.2.0, 2021-11-15 23:36
 */
public class LC450 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode min = getMin(root.right);
            root.val = min.val;
            min.val = key;
            root.right = deleteNode(root.right, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public TreeNode getMin(TreeNode root) {
        while (null != root.left) {
            root = root.left;
        }
        return root;
    }

}
