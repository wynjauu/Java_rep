/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.data.List;

/**
 * JZ24 反转链表
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-21 23:05
 * @since 1.2.0, 2021-10-21 23:05
 */
public class JZ24 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solution(ListNode listNode) {
        if (null == listNode) {
            return listNode;
        }

        ListNode pre = null;
        ListNode cur = listNode;
        while (null != cur) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
