/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.dfs;

/**
 * Java_rep: NC62 判断是不是平衡二叉树
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-27 22:56
 * @since 1.2.0, 2021-12-27 22:56
 */
public class NC62 {

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(higher(root.left) - higher(root.right)) <= 1) {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
        return false;
    }

    public int higher(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = higher(node.left) + 1;
        int right = higher(node.right) + 1;
        return Math.max(left, right);
    }
}
