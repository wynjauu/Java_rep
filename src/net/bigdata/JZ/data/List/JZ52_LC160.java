/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.data.List;

/**
 * JZ52 两个链表的第一个公共结点
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-22 22:41
 * @since 1.2.0, 2021-10-22 22:41
 */
public class JZ52_LC160 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solution(ListNode pHead1, ListNode pHead2) {
        if (null == pHead1) {
            return pHead1;
        }
        if (null == pHead2) {
            return pHead2;
        }
        ListNode listNode1 = pHead1;
        ListNode listNode2 = pHead2;
        while (listNode1 != listNode2) {
            if (null == listNode1) {
                listNode1 = pHead2;
            } else {
                listNode1 = listNode1.next;
            }
            if (null == listNode2) {
                listNode2 = pHead1;
            } else {
                listNode2 = listNode2.next;
            }
        }
        return listNode1;
    }
}
