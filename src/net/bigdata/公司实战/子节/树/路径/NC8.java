/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.路径;

import java.util.ArrayList;

/**
 * Java_rep: NC8 二叉树中和为某一值的路径(二)
 * https://programmercarl.com/0112.%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.html#java
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 23:17
 * @since 1.2.0, 2021-12-07 23:17
 */
public class NC8 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        digui(root, expectNumber);
        return listAll;
    }

    public static void digui(TreeNode root, int expectNumber) {
        if (root == null) {
            return;
        }

        //递归前把路径值放入列表中
        list.add(root.val);
        expectNumber -= root.val;
        if (expectNumber == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        digui(root.left, expectNumber);
        digui(root.right, expectNumber);
        list.remove(list.size() - 1); // 回溯
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        node.left = node1;
        node.right = node2;

        ArrayList<ArrayList<Integer>> result = FindPath(node, 1);
        System.out.println(result);
    }
}
