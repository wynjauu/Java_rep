/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.树;

/**
 * java_20190508: 654. 最大二叉树
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-13 22:32
 * @since 1.2.0, 2021-11-13 22:32
 */
public class LC654 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode solution(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = -1;
        int maxVal = Integer.MIN_VALUE;

        for (int i = start; i <= end; i++) {
            if (nums[i] > maxVal) {
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = helper(nums, start, index - 1);
        root.right = helper(nums, index + 1, end);
        return root;
    }
}
