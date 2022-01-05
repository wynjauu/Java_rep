/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Java_rep: NC13 二叉树的最大深度
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 22:01
 * @since 1.2.0, 2021-12-07 22:01
 */
public class NC13 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /*
     * 解法一：
     * 递归解法，非常简洁
     */
    public int maxDepth(TreeNode root) {
        // write code here
        if (null == root) {
            return 0;
        }
        int l = maxDepth(root.left) + 1;
        int r = maxDepth(root.right) + 1;
        return Math.max(l, r);
    }

    /*
     * 解法二：
     * 使用queue进行层序遍历
     */
    public int maxDepth2(TreeNode root) {
        // write code here
        if (null == root) {
            return 0;
        }

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            lists.add(list);
        }
        return lists.size();
    }

}
