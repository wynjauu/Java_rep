/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.镜像;

/**
 * Java_rep: NC72 二叉树的镜像
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-09 10:00
 * @since 1.2.0, 2021-12-09 10:00
 */
public class NC72 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * ##采用递归思想##
     * 后序遍历 可以画图来看交换的过程（按题目的三层）：
     * 先递归得到root的最后一层l/r,然后交换，然后回朔到的倒数第二层的l;
     * 然后下一步到root的右边最后一层l/r,然后交换,然后回朔到的倒数第二层的r；
     * 然后倒数第二层的l/r交换，回溯到root,结束递归
     *
     * @param pRoot
     * @return
     */
    public TreeNode Mirror(TreeNode pRoot) {
        // write code here
        //1、如果根节点为空，直接返回null
        if (null == pRoot) {
            return null;
        }
        //2、如果根的左右节点都是空，返回根节点
        if (pRoot.left == null && pRoot.right == null) {
            return pRoot;
        }
        //3、交换左右节点（这里遍历是左右根的后序遍历）
        TreeNode l = Mirror(pRoot.left);
        TreeNode r = Mirror(pRoot.right);
        TreeNode temp = l;
        pRoot.left = r;
        pRoot.right = temp;
        return pRoot;
    }
}
