/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.dfs;

/**
 * Java_rep: NC5 二叉树根节点到叶子节点的所有路径和
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-27 23:25
 * @since 1.2.0, 2021-12-27 23:25
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

    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return res;
    }

    //先序遍历的思想(根左右)+数字求和(每一层都比上层和*10+当前根节点的值)
    public void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += val;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        root.left = node1;
//        root.right = node2;
//        sumNumbers(root);
//    }
}
