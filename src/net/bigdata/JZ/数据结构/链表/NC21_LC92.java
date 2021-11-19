/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.链表;

/**
 * java_20190508: LC92. 反转链表 II
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-05 23:36
 * @since 1.2.0, 2021-11-05 23:36
 */
public class NC21_LC92 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dump = new ListNode(-1);
        dump.next = head;

        ListNode a = dump;
        ListNode b = dump;

        ListNode pre = dump;

        for (int i = 1; i <= right; i++) {
            if (i == left) {
                pre = b;
                a = b.next;
            }
            b = b.next;
        }

        b = b.next;
        ListNode tail = helper(a, b);
        pre.next = tail;
        return dump.next;
    }

    /**
     * @param head 1->2->3->4->5
     * @param node 4->5
     * @return 3->2->1->4->5
     */
    public static ListNode helper(ListNode head, ListNode node) {
        ListNode pre = node;
        ListNode cur = head;
        while (node != cur) {
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode solution = reverseBetween(node5, 1, 1);
        while (null != solution) {
            System.out.println(solution.val);
            solution = solution.next;
        }
    }
}
