/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.路径;

/**
 * Java_rep: NC5 二叉树根节点到叶子节点的所有路径和
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 22:41
 * @since 1.2.0, 2021-12-07 22:41
 */
public class NC5 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //先序遍历的思想(根左右)+数字求和(每一层都比上层和*10+当前根节点的值)
    public int sumNumbers(TreeNode root) {
        // write code here
        int sum = 0;
        if (root == null) {
            return sum;
        }
        return helper(root, sum);
    }

    public int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return helper(root.left, sum) + helper(root.right, sum);
    }
}
