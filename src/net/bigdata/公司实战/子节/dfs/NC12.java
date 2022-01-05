/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.dfs;

import java.util.Arrays;

/**
 * Java_rep: NC12 重建二叉树
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-27 22:28
 * @since 1.2.0, 2021-12-27 22:28
 */
public class NC12 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);

        int index = 0;
        for (int i = 0; i < vin.length; i++) {
            if (vin[i] == pre[0]) {
                index = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(vin, 0, index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(vin, index + 1, vin.length));
        return root;
    }
}
