/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树;

/**
 * NC102 在二叉树中找到两个节点的最近公共祖先
 * https://labuladong.github.io/algo/2/18/30/
 * https://mp.weixin.qq.com/s/9RKzBcr3I592spAsuMH45g
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 17:25
 * @since 1.2.0, 2021-12-07 17:25
 */
public class NC102 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        TreeNode node = helper(root, o1, o2);
        if (null != node) {
            return node.val;
        }
        return -1;
    }

    /**
     * 这里画图讲解的好： https://programmercarl.com/0236.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html#java
     *
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public TreeNode helper(TreeNode root, int o1, int o2) {
        //基础条件
        if (root == null) {
            return null;
        }
        if (root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode left = helper(root.left, o1, o2);
        TreeNode right = helper(root.right, o1, o2);

        if (null == left && null == right) {
            return null;
        }
        if (null != left && null != right) {
            return root;
        }
        return left == null ? right : left;
    }
}
