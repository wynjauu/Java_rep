/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * java_20190508: LC95. 不同的二叉搜索树 II
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-18 22:30
 * @since 1.2.0, 2021-11-18 22:30
 */
public class LC95 {
    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int[][] memo = null;

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    public List<TreeNode> helper(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }

        for (int i = lo; i <= hi; i++) {
            List<TreeNode> left = helper(lo, i - 1);
            List<TreeNode> right = helper(i + 1, hi);
            for (TreeNode lNode : left) {
                for (TreeNode rNode : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = lNode;
                    treeNode.right = rNode;
                    res.add(treeNode);
                }
            }
        }
        return res;
    }
}
