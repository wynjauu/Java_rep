/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Java_rep: NC15 求二叉树的层序遍历
 * https://programmercarl.com/0102.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86.html
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 14:21
 * @since 1.2.0, 2021-12-07 14:21
 */
public class NC15 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        checkFun02(root);
        return resList;
    }

    //BFS--迭代方式--借助队列
    private void checkFun02(TreeNode root) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
                size--;
            }
            resList.add(list);
        }
    }
}
