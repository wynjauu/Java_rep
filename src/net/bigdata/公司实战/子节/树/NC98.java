/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树;

/**
 * Java_rep: NC98 判断t1树中是否有与t2树完全相同的子树
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-09 10:45
 * @since 1.2.0, 2021-12-09 10:45
 */
public class NC98 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isContains(TreeNode root1, TreeNode root2) {
        // write code here
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        //两个根节点不想等，则用root1的左右子树分别和root2比较
        if (root1.val != root2.val) {
            return isContains(root1.left, root2) || isContains(root1.right, root2);
        } else { //root1和root2相同，继续对比
            return isSame(root1, root2);
        }
    }

    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        //两个根节点都不为空，继续比较
        boolean l = isSame(root1.left, root2.left);
        boolean r = isSame(root1.right, root2.right);
        return l && r;
    }


}
