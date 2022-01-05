/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC53 删除链表的倒数第n个节点
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 16:19
 * @since 1.2.0, 2021-12-06 16:19
 */
public class NC53 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if (null == head) {
            return null;
        }
        if (n <= 0) {
            return head;
        }

        //first先走到k+1个节点
        ListNode first = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        //first走到null的时候，second就走到倒数k+1个节点了
        while (null != first) {
            first = first.next;
            p = p.next;
        }

        p.next = p.next.next;
        return dummy.next;
    }
}
