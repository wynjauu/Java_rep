/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.路径;

/**
 * Java_rep: NC9 二叉树中和为某一值的路径(一)
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-08 23:02
 * @since 1.2.0, 2021-12-08 23:02
 */
public class NC9 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        sum = sum - root.val;
        if (0 == sum && root.left == null && root.right == null) {
            return true;
        }
        boolean l = hasPathSum(root.left, sum);
        boolean r = hasPathSum(root.right, sum);
        return l || r;
    }
}
