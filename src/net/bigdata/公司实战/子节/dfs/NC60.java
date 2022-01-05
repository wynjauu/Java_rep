/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java_rep: NC60 判断一棵二叉树是否为搜索二叉树和完全二叉树
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-28 15:24
 * @since 1.2.0, 2021-12-28 15:24
 */
public class NC60 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean[] judgeIt(TreeNode root) {
        boolean bst = bst(root);
        boolean cbt = cbt(root);
        return new boolean[]{bst, cbt};
    }

    /**
     * https://labuladong.github.io/algo/2/18/25/
     *
     * @param root
     * @return
     */
    public boolean bst(TreeNode root) {
        return bstHelper(root, null, null);
    }

    public boolean bstHelper(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        boolean left = bstHelper(root.left, min, root);
        boolean right = bstHelper(root.right, root, max);
        return left && right;
    }


    public boolean cbt(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leaf && node.left != null && node.right != null) {
                    return false;
                }
                if (node.left == null && node.right != null) {
                    return false;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                } else {
                    leaf = true;
                }
            }
        }
        return true;
    }
}
