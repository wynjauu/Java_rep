/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.遍历;

import java.util.ArrayList;

/**
 * Java_rep: NC45 实现二叉树先序，中序和后序遍历
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 11:54
 * @since 1.2.0, 2021-12-07 11:54
 */
public class NC45 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    ArrayList<Integer> m = new ArrayList<>();
    ArrayList<Integer> f = new ArrayList<>();
    ArrayList<Integer> b = new ArrayList<>();

    public int[][] threeOrders(TreeNode root) {
        helper1(root);
        helper2(root);
        helper3(root);


        int preList[] = new int[f.size()];
        for (int i = 0; i < f.size(); i++) {
            preList[i] = f.get(i);
        }

        int inList[] = new int[m.size()];
        for (int i = 0; i < m.size(); i++) {
            inList[i] = m.get(i);
        }
        int postList[] = new int[b.size()];
        for (int i = 0; i < b.size(); i++) {
            postList[i] = b.get(i);
        }
        int[][] returnMatrix = new int[][]{preList, inList, postList};
        return returnMatrix;
    }

    public void helper1(TreeNode root) {
        if (null == root) {
            return;
        }
        f.add(root.val);
        helper1(root.left);
        helper1(root.right);
    }

    public void helper2(TreeNode root) {
        if (null == root) {
            return;
        }
        helper2(root.left);
        m.add(root.val);
        helper2(root.right);
    }

    public void helper3(TreeNode root) {
        if (null == root) {
            return;
        }
        helper3(root.left);
        helper3(root.right);
        b.add(root.val);
    }
}
