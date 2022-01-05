/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC78 反转链表
 * https://labuladong.github.io/algo/2/17/18/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 13:40
 * @since 1.2.0, 2021-12-06 13:40
 */
public class NC78 {

    public static class ListNode {
        int val;
        ListNode next;

        public void ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 反转 a 到 null 之间的结点
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (null == head) {
            return head;
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
