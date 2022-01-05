/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC69
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 11:37
 * @since 1.2.0, 2021-12-07 11:37
 */
public class NC69 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        if (null == pHead || k <= 0) {
            return null;
        }
        ListNode fast = pHead;
        for (int i = 1; i <= k; i++) {
            if (null == fast) {
                return null;
            }
            fast = fast.next;
        }
        ListNode slow = pHead;
        while (null != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
