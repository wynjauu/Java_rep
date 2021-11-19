/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.树;

/**
 * java_20190508: JZJZ7_LC105. 从前序与中序遍历序列构造二叉树
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-13 23:14
 * @since 1.2.0, 2021-11-13 23:14
 */
public class JZZ7_LC105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode solution(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {//if (postStart > postEnd) {
            return null;
        }
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }

        TreeNode node = new TreeNode(preorder[preStart]);
        int leftSize = index - inStart;
        node.left = helper(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        node.right = helper(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return node;
    }
}
