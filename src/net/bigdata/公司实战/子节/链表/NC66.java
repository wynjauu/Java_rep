/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC66 两个链表的第一个公共结点
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 16:51
 * @since 1.2.0, 2021-12-06 16:51
 */
public class NC66 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != node2) {
            if (node1 == null) {
                node1 = pHead2;
            } else {
                node1 = node1.next;
            }
            if (node2 == null) {
                node2 = pHead1;
            } else {
                node2 = node2.next;
            }
        }
        return node1;
    }
}
