/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.二叉树;

/**
 * java_20190508: JZ27 二叉树的镜像
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-09 23:49
 * @since 1.2.0, 2021-11-09 23:49
 */
public class JZ27 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Mirror(TreeNode pRoot) {
        if (null == pRoot) {
            return null;
        }
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;

        Mirror(pRoot.right);
        Mirror(pRoot.left);
        return pRoot;
    }
}
