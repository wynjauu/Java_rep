/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC40 两个链表生成相加链表
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 17:13
 * @since 1.2.0, 2021-12-06 17:13
 */
public class NC40 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 模仿大数加法
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        if (null == head1) {
            return head2;
        }
        if (null == head2) {
            return head1;
        }
        //1、反转
        ListNode r1 = reverse(head1);
        ListNode r2 = reverse(head2);

        ListNode dummy = new ListNode(-1);
        int cache = 0;
        ListNode cur = dummy;

        //2、相加
        while (r1 != null || r2 != null || cache > 0) {
            int sum = 0;
            if (r1 != null) {
                sum = sum + r1.val;
                r1 = r1.next;
            }
            if (r2 != null) {
                sum = sum + r2.val;
                r2 = r2.next;
            }
            if (cache > 0) {
                sum = sum + cache;
            }
            ListNode newNode = new ListNode(sum % 10);
            cache = sum / 10;
            cur.next = newNode;
            cur = cur.next;
        }

        //3、反转
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
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

}
