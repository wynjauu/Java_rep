/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.二叉树;

import java.util.LinkedList;

/**
 * java_20190508: LC297. 二叉树的序列化与反序列化
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-20 15:53
 * @since 1.2.0, 2021-11-20 15:53
 */
public class LC297 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        return SerHelper(root, stringBuilder).toString();
    }

    public StringBuilder SerHelper(TreeNode root, StringBuilder stringBuilder) {
        if (null == root) {
            stringBuilder.append("#").append(",");
            return stringBuilder;
        }
        stringBuilder.append(root.val).append(",");
        SerHelper(root.left, stringBuilder);
        SerHelper(root.right, stringBuilder);
        return stringBuilder;
    }


    public TreeNode deserialize(String data) {
        if (null == data || data.length() == 0) {
            return null;
        }
        String[] strings = data.split(",");
        LinkedList<String> nodes = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            nodes.add(strings[i]);
        }
        return desHelper(nodes);
    }

    public TreeNode desHelper(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String node = nodes.removeFirst();
        if (node.equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(node));
        treeNode.left = desHelper(nodes);
        treeNode.right = desHelper(nodes);
        return treeNode;
    }
}
