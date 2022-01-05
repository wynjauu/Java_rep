/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树.路径;

/**
 * Java_rep: NC6 二叉树中的最大路径和
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-08 17:55
 * @since 1.2.0, 2021-12-08 17:55
 */
public class NC6 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 以当前节点为根的最大值，再到整个树
     *
     * @param root
     * @return
     */
    /*
     * 124. Binary Tree Maximum Path Sum
     * 解题思路：（转载自：<a href="http://blog.csdn.net/linhuanmars/article/details/22969069" target="_blank">http://blog.csdn.net/linhuanmars/article/details/22969069）
     * 这道题是求树的路径和的题目，不过和平常不同的是这里的路径不仅可以从根到某一个结点，
     * 而且路径可以从左子树某一个结点，然后到达右子树的结点，就像题目中所说的可以起始和终结于任何结点。
     * 在这里树没有被看成有向图，而是被当成无向图来寻找路径。
     * 因为这个路径的灵活性，我们需要对递归返回值进行一些调整，而不是通常的返回要求的结果。
     * 在这里，函数的返回值定义为以自己为根的一条从根到子结点的最长路径（这里路径就不是当成无向图了，必须往单方向走）。
     * 这个返回值是为了提供给它的父结点计算自身的最长路径用，而结点自身的最长路径（也就是可以从左到右那种）则只需计算然后更新即可。
     * 这样一来，一个结点自身的最长路径就是它的左子树返回值（如果大于0的话），加上右子树的返回值（如果大于0的话），再加上自己的值。
     * 而返回值则是自己的值加上左子树返回值，右子树返回值或者0（注意这里是“或者”，而不是“加上”，因为返回值只取一支的路径和）。
     * 在过程中求得当前最长路径时比较一下是不是目前最长的，如果是则更新。
     * 算法的本质还是一次树的遍历，所以复杂度是O(n)。而空间上仍然是栈大小O(logn)。
     */

    // 因为maxPathSum不一定经过根节点，所以用maxValue整个遍历过程中出现过的最大值
    static int maxValue = 0;

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxValue = Integer.MIN_VALUE;
        getMaxPathSum(root);
        return maxValue;
    }

    private static int getMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //因为节点的值可以为负数，所以最大值取0和子树值的较大者
        int leftMax = Math.max(0, getMaxPathSum(root.left));
        int rightMax = Math.max(0, getMaxPathSum(root.right));
        //如果将当前root作为根节点，那么最大值是root.val+左子树最大值+右子树最大值
        maxValue = Math.max(maxValue, root.val + leftMax + rightMax);
        //只能返回左右子树中较大值加上root.val，然后给当前节点的root节点使用，因为只能从left/rigght节点->当前root->当前root的root
        return Math.max(0, root.val + Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-3);
        TreeNode node1 = new TreeNode(-2);
        node.right = node1;
        maxPathSum(node);
    }
}
