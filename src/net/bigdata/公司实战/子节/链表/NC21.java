/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC21 链表内指定区间反转
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 23:18
 * @since 1.2.0, 2021-12-06 23:18
 */
public class NC21 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (null == head) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode b = dummy;
        ListNode a = null;

        for (int i = 1; i <= n; i++) {
            if (null == b) {
                return head;
            }
            if (i == m) {
                pre = b;
                a = b.next;
            }
            b = b.next;
        }
        b = b.next;
        ListNode revNode = reverse(a, b);
        pre.next = revNode;
        return dummy.next;
    }

    /**
     * 反转[a,b)
     *
     * @param a 1->2->3->4->5
     * @param b 4->5
     * @return 3->2->1->4->5
     */
    public ListNode reverse(ListNode a, ListNode b) {
        if (null == a) {
            return null;
        }
        ListNode cur = a;
        ListNode pre = b; //特别注意这边不是:ListNode pre = null,,,,如果是的那就返回的就是：3->2->1
        while (b != cur) {
            ListNode tmp = cur.next;

            cur.next = pre;
            pre = cur;

            cur = tmp;
        }
        return pre;
    }
}
