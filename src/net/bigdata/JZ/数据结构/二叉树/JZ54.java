/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.二叉树;

/**
 * java_20190508: JZ54 二叉搜索树的第k个结点
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-14 23:39
 * @since 1.2.0, 2021-11-14 23:39
 */
public class JZ54 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int pointer = 0;
    TreeNode res = null;

    TreeNode KthNode(TreeNode pRoot, int k) {
        helper(pRoot, k);
        return res;
    }

    void helper(TreeNode pRoot, int k) {

        if (null == pRoot) {
            return;
        }
        helper(pRoot.left, k);
        pointer = pointer + 1;
        if (pointer == k) {
            res = pRoot;
            return;
        }
        helper(pRoot.right, k);
    }
}
