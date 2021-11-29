/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 * java_20190508: LC652. 寻找重复的子树
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-14 22:47
 * @since 1.2.0, 2021-11-14 22:47
 */
public class LC652 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return res;
    }

    //所有子树以及出现的次数
    HashMap<String, Integer> subNodeMap = new HashMap<>();
    //记录重复的子树根节点
    ArrayList<TreeNode> res = new ArrayList<>();

    public String helper(TreeNode root) {
        if (null == root) {
            return "#";
        }

        String left = helper(root.left);
        String right = helper(root.right);

        String subNode = left + "," + right + "," + root.val;
        int subNodeCount = subNodeMap.getOrDefault(subNode, 1);

        if (subNodeCount == 2) {
            res.add(root);
        }
        subNodeMap.put(subNode, subNodeCount + 1);
        return subNode;
    }
}
