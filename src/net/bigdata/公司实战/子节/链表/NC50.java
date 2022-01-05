/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC50 链表中的节点每k个一组翻转
 * https://labuladong.github.io/algo/2/17/18/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 14:14
 * @since 1.2.0, 2021-12-06 14:14
 */
public class NC50 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        if (null == head) {
            return head;
        }
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (null == b) {
                return head;
            }
            b = b.next;
        }

        ListNode a = head;
        //链表的前序遍历
        ListNode reverseNode = reverse(a, b);

        a.next = reverseKGroup(b, k);
        return reverseNode;
    }

    //反转[a,b)之间的链表
    public ListNode reverse(ListNode a, ListNode b) {

        ListNode cur = a;
        ListNode pre = null;

        while (cur != b) {
            ListNode temp = cur.next;

            cur.next = pre;
            pre = cur;

            cur = temp;
        }
        return pre;
    }


}
