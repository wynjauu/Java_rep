/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.回文;

/**
 * Java_rep: LC234. 回文链表
 * https://labuladong.github.io/algo/2/17/19/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-05 18:09
 * @since 1.2.0, 2021-12-05 18:09
 */
public class LC234 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：递归
     *
     * @param head
     * @return
     */
    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return helper(head);
    }

    public boolean helper(ListNode right) {
        if (null == right) {
            return true;
        }
        boolean res = helper(right.next);
        // 后序遍历代码
        res = res && left.val == right.val;
        left = left.next;
        return res;
    }

    /**
     * 方法二：快慢指针 + 反转指标
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode reverse = reverse(slow);
        ListNode right = reverse;
        ListNode left = head;
        while (right != null) {
            if (right.val != left.val) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
