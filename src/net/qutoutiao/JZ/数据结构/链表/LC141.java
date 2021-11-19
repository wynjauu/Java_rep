/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.JZ.数据结构.链表;

/**
 * java_20190508: LC141 环形链表
 * 力扣通过了
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-30 21:17
 * @since 1.2.0, 2021-10-30 21:17
 */
public class LC141 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean solution(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
