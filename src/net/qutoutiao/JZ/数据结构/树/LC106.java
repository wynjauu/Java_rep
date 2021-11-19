/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.JZ.数据结构.树;

/**
 * java_20190508: lc106. 从中序与后序遍历序列构造二叉树
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-13 23:53
 * @since 1.2.0, 2021-11-13 23:53
 */
public class LC106 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode solution(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {//if (postStart > postEnd) {
            return null;
        }

        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (postorder[postEnd] == inorder[i]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int leftSize = index - inStart;
        root.left = helper(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = helper(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
