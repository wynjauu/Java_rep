/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.遍历;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Java_rep: NC136 输出二叉树的右视图
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 19:41
 * @since 1.2.0, 2021-12-07 19:41
 */
public class NC136 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int[] solve(int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode root = buildTree(xianxu, zhongxu);
        ArrayList<ArrayList<Integer>> lists = helper(root);
        int[] result = new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            result[i] = lists.get(i).get(lists.get(i).size() - 1);
        }
        return result;
    }

    //二叉树的层次遍历
    public ArrayList<ArrayList<Integer>> helper(TreeNode root) {
        //层次遍历
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
            if (!list.isEmpty()) {
                lists.add(list);
            }
        }
        return lists;
    }

    //重建二叉树
    public TreeNode buildTree(int[] xianxu, int[] zhongxu) {
        if (null == xianxu || null == zhongxu
                || xianxu.length == 0 || zhongxu.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(xianxu[0]);
        int splitIndex = 0;
        for (int i = 0; i < zhongxu.length; i++) {
            if (xianxu[0] == zhongxu[i]) {
                splitIndex = i;
                break;
            }
        }
        root.left = buildTree(
                Arrays.copyOfRange(xianxu, 1, splitIndex + 1),
                Arrays.copyOfRange(zhongxu, 0, splitIndex));
        root.right = buildTree(
                Arrays.copyOfRange(xianxu, splitIndex + 1, xianxu.length),
                Arrays.copyOfRange(zhongxu, splitIndex + 1, zhongxu.length));
        return root;
    }
}
