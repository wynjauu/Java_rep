/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.动态规划.打家劫舍;

/**
 * Java_rep: LC337
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-03 22:19
 * @since 1.2.0, 2021-12-03 22:19
 */
public class LC337 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int rob(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode root) {
        int[] res = new int[2];
        if (null == root) {
            return res;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        //当前节点不选,所以是res[0]，那么他的子节点就是选不选就看max
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //如果选的话，那么他的子节点肯定是不选的
        res[1] = left[0] + right[0] + root.val;
        return res;
    }


    public static int high(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int l = high(root.left) + 1;
        int r = high(root.right) + 1;
        return Math.max(l, r);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;
        node4.right = node6;
        System.out.println(high(node1));
    }
}
