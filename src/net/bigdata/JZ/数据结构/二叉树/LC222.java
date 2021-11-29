/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.二叉树;

/**
 * java_20190508: LC222. 完全二叉树的节点个数
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-20 19:22
 * @since 1.2.0, 2021-11-20 19:22
 */
public class LC222 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int countNodes(TreeNode root) {
        TreeNode r = root;
        TreeNode l = root;

        int rHigh = 0;
        int lHigh = 0;

        while (null != r) {
            rHigh++;
            r = r.right;
        }

        while (null != l) {
            lHigh++;
            l = l.left;
        }

        if (rHigh == lHigh) {
            return (int) Math.pow(2, rHigh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
