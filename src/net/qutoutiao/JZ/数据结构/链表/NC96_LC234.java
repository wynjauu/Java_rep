/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.JZ.数据结构.链表;

/**
 * 234. 回文链表
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-08 23:39
 * @since 1.2.0, 2021-11-08 23:39
 */
public class NC96_LC234 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 指针现在指向链表中点
        //基数的时候，反转链表开头指针是下一个
        if (null != fast) {
            slow = slow.next;
        }
        ListNode right = hepler(slow);
        ListNode left = head;
        while (null != right) {
            if (left.val != right.val) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static ListNode hepler(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

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
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        //node4.next = node5;
        System.out.println(isPalindrome(node1));
    }
}
