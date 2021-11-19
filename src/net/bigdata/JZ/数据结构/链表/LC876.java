/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.链表;

/**
 * 876. 链表的中间结点
 * 力扣通过
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-29 00:05
 * @since 1.2.0, 2021-10-29 00:05
 */
public class LC876 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
