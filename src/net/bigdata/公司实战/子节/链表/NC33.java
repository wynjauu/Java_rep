/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

import java.util.List;

/**
 * Java_rep: NC33 合并两个排序的链表
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 15:02
 * @since 1.2.0, 2021-12-06 15:02
 */
public class NC33 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode p = dummy;

        while (null != node1 && null != node2) {
            if (node1.val > node2.val) {
                p.next = node2;
                p = p.next; //p = node2;
                node2 = node2.next;
            } else {
                p.next = node1;
                p = p.next;//p = node1;
                node1 = node1.next;
            }
        }

        if (null == node1) {
            p.next = node2;
        }
        if (null == node2) {
            p.next = node1;
        }
        return dummy.next;
    }
}
