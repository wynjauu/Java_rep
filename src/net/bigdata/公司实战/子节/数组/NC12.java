/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

import java.util.Arrays;

/**
 * Java_rep: NC12
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-15 21:58
 * @since 1.2.0, 2021-12-15 21:58
 */
public class NC12 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] pre, int[] vin) {
        if ((pre == null || pre.length == 0)
                && (vin == null || vin.length == 0)) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        int split = 0;
        for (int j = 0; j < vin.length; j++) {
            if (vin[j] == pre[0]) {
                split = j;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(pre, 1, split + 1), Arrays.copyOfRange(vin, 0, split));
        root.right = buildTree(Arrays.copyOfRange(pre, split + 1, pre.length), Arrays.copyOfRange(vin, split + 1, vin.length));
        return root;
    }
}
