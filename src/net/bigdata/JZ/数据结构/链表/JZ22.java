/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.链表;

/**
 * JZ22 链表中倒数最后k个结点
 * 牛客网通过了
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-23 22:35
 * @since 1.2.0, 2021-10-23 22:35
 */
public class JZ22 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solution(ListNode pHead, int k) {
        if (null == pHead) {
            return null;
        }
        if (0 == k) {
            return null;
        }
        ListNode head1 = pHead;
        // head1 先走到 k 的位置
        for (int i = 1; i < k; i++) {
            head1 = head1.next;
            if (head1 == null) {//k>pHead的节点个数
                return null;
            }
        }

        ListNode head2 = pHead;
        // head1 和 head2 同时走 n - k 步
        while (null != head1.next) {
            head2 = head2.next;
            head1 = head1.next;
        }
        // p2 现在指向第 n - k + 1 个节点
        return head2;
    }
}
