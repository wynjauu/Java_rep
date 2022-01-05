/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.判断树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java_rep: NC60 判断一棵二叉树是否为搜索二叉树和完全二叉树
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-08 10:37
 * @since 1.2.0, 2021-12-08 10:37
 */
public class NC60 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean[] judgeIt(TreeNode root) {
        // write code here
        return new boolean[]{isBST(root), isCBT(root)};
    }

    /**
     * 判断一棵二叉树是否为搜索二叉树，只要改写一个二叉树中序遍历，在遍历的过程中看节点值是否都是递增的即可。
     * https://programmercarl.com/0098.%E9%AA%8C%E8%AF%81%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91.html#java
     *
     * @param root
     * @return
     */
    long prev = Long.MIN_VALUE;

    public boolean isBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        if (!isBST(root.left)) {
            return false;
        }
        if (prev >= root.val) {
            return false;
        }
        prev = root.val;
        return isBST(root.right);
    }

    /**
     * 判断一棵二叉树是否为完全二叉树，依据以下标准会使判断过程变得简单且易实现。
     * 1．按层遍历二叉树，从每层的左边向右边依次遍历所有的节点。
     * 2．如果当前节点有右孩子节点，但没有左孩子节点，则直接返回 false。
     * 3．如果当前节点并不是左右孩子节点全有，那么之后的节点必须都为叶节点，否则返回false。
     * 4．遍历过程中如果不返回 false，则遍历结束后返回 true。
     *
     * @param root
     * @return
     */
    public static boolean isCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //如果当前节点并不是左右孩子节点全有，那么之后的节点必须都为叶节点
                if (leaf && (node.left != null || node.right != null)) {
                    return false;
                }
                //如果当前节点有右孩子节点，但没有左孩子节点，则直接返回 false
                if (node.left == null && node.right != null) {
                    return false;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                } else {
                    leaf = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        //node4.right = node6;

        System.out.println(isCBT(node1));
    }
}
