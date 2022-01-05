/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java_rep: NC123 序列化二叉树
 * https://labuladong.github.io/algo/2/18/28/
 * https://mp.weixin.qq.com/s/DVX2A1ha4xSecEXLxW_UsA
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-08 23:43
 * @since 1.2.0, 2021-12-08 23:43
 */
public class NC123 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Shelper(root, builder);
        return builder.toString();
    }

    StringBuilder Shelper(TreeNode root, StringBuilder builder) {
        if (null == root) {
            return builder.append("#").append(",");
        }
        builder.append(root.val).append(",");
        Shelper(root.left, builder);
        Shelper(root.right, builder);
        return builder;
    }

    TreeNode Deserialize(String str) {
        Queue<String> queue = new LinkedList<>();
        String[] arrayStr = str.split(",");
        for (int i = 0; i < arrayStr.length; i++) {
            String c = arrayStr[i];
            queue.offer(c);
        }
        return Dhelper(queue);
    }

    TreeNode Dhelper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String it = queue.poll();
        if (it.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(it));
        root.left = Dhelper(queue);
        root.right = Dhelper(queue);
        return root;
    }
}
