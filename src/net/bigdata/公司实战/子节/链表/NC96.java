/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC96 判断一个链表是否为回文结构
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 21:54
 * @since 1.2.0, 2021-12-06 21:54
 */
public class NC96 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPail(ListNode head) {
        // write code here
        if (null == head) {
            return false;
        }
        //找指针的中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        //反转链表
        ListNode revNode = reverse(slow);
        ListNode node1 = head;
        ListNode node2 = revNode;
        while (node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            node2 = node2.next;
            node1 = node1.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;

        while (null != cur) {
            ListNode temp = cur.next;

            cur.next = pre;
            pre = cur;

            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(1);
        ListNode node10 = new ListNode(1);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        isPail(node1);
    }

}
