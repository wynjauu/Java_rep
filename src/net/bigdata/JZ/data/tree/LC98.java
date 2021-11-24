/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.data.tree;

/**
 * java_20190508: LC98. 验证二叉搜索树
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-15 23:10
 * @since 1.2.0, 2021-11-15 23:10
 */
public class LC98 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (null == root) {
            return true;
        }
        if (null != min && root.val <= min.val) return false;
        if (null != max && root.val >= max.val) return false;
        return helper(root.left, min, root) && helper(root.right, root, max);
    }
}
