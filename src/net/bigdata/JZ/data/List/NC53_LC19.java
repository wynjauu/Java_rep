/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.data.List;

/**
 * NC53=LC19 删除链表的倒数第 N 个结点
 * 牛客网已经通过（NC53 删除链表的倒数第n个节点）
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-23 23:55
 * @since 1.2.0, 2021-10-23 23:55
 */
public class NC53_LC19 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solution(ListNode head, int n) {
        // write code here
        if (null == head || n == 0) {
            return head;
        }
        ListNode head1 = head;
        for (int i = 1; i < n; i++) {
            head1 = head1.next;
            if (null == head1) { //n>head的节点个数
                return head;
            }
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode head2 = dummy;
        while (head1.next != null) {
            head1 = head1.next;
            head2 = head2.next;
        }
        head2.next = head2.next.next;
        return dummy.next;
    }
}
