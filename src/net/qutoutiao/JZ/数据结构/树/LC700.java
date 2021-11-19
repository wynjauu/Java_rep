/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.JZ.数据结构.树;

/**
 * java_20190508: LC700. 二叉搜索树中的搜索
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-15 23:20
 * @since 1.2.0, 2021-11-15 23:20
 */
public class LC700 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return root;
    }
}
