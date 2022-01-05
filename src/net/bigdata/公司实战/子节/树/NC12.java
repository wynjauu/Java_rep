/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树;

import java.util.Arrays;

/**
 * Java_rep: NC12 重建二叉树
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 18:58
 * @since 1.2.0, 2021-12-07 18:58
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

    /**
     * 知识点：
     * <p>
     * 前序遍历列表：第一个元素永远是 【根节点 (root)】
     * 中序遍历列表：根节点 (root)【左边】的所有元素都在根节点的【左分支】，【右边】的所有元素都在根节点的【右分支】
     * 算法思路：
     * <p>
     * 通过【前序遍历列表】确定【根节点 (root)】
     * 将【中序遍历列表】的节点分割成【左分支节点】和【右分支节点】
     * 递归寻找【左分支节点】中的【根节点 (left child)】和 【右分支节点】中的【根节点 (right child)】
     *
     * @param pre
     * @param vin
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (null == pre || pre.length == 0 || null == vin || vin.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int splitIndex = 0;
        for (int i = 0; i < vin.length; i++) {
            if (vin[i] == pre[0]) {
                splitIndex = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(
                Arrays.copyOfRange(pre, 1, splitIndex + 1),
                Arrays.copyOfRange(vin, 0, splitIndex)
        );
        root.right = reConstructBinaryTree(
                Arrays.copyOfRange(pre, splitIndex + 1, pre.length),
                Arrays.copyOfRange(vin, splitIndex + 1, vin.length)
        );
        return root;
    }
}
