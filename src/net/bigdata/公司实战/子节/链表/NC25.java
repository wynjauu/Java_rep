/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC25 删除有序链表中重复的元素-I
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 00:30
 * @since 1.2.0, 2021-12-07 00:30
 */
public class NC25 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1→1→1→2→3, 返回1->2->3
     * 1→2→3→3→4→4→5, 返回1->2->3->4->5
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        // write code here
        if (null == head) {
            return null;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (null != right) {
            if (right.val == left.val) {
                right = right.next;
                left.next = right;
            } else {
                left.next = right;
                left = left.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode list = deleteDuplicates2(node);

    }
}
