/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC2
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 09:27
 * @since 1.2.0, 2021-12-07 09:27
 */
public class NC2 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // 快慢指针找到中间节点（注意：这里跟之前的找中节点不太一样）
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 拆分链表，并反转中间节点之后的链表
        ListNode after = slow.next;
        slow.next = null; //为了截取head前缀一部分
        ListNode pre = null;
        while (after != null) {
            ListNode temp = after.next;
            after.next = pre;
            pre = after;
            after = temp;
        }
        // 合并两个链表
        ListNode first = head;
        after = pre;
        while (first != null && after != null) {
            ListNode ftemp = first.next;
            ListNode aftemp = after.next;
            first.next = after;
            after.next = ftemp;
            first = ftemp;
            after = aftemp;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        //ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //node4.next = node5;
        reorderList(node1);

    }
}
