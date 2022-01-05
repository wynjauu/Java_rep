/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.判断树;

/**
 * Java_rep: NC62 判断是不是平衡二叉树
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 22:19
 * @since 1.2.0, 2021-12-07 22:19
 */
public class NC62 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public boolean IsBalanced_Solution(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (Math.abs(getHigh(root.left) - getHigh(root.right)) <= 1) {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
        return false;
    }

    public int getHigh(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int l = getHigh(root.left) + 1;
        int r = getHigh(root.right) + 1;
        return Math.max(l, r);
    }
}
