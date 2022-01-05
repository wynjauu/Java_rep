/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

import java.util.PriorityQueue;

/**
 * Java_rep: NC70 单链表的排序
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 19:19
 * @since 1.2.0, 2021-12-06 19:19
 */
public class NC70 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 优先队列
     *
     * @param head
     * @return
     */
    public ListNode sortInList(ListNode head) {
        if (null == head) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode p = head;
        while (null != p) {
            priorityQueue.offer(p);
            p = p.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode dm = dummy;

        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            dm.next = poll;
            dm = dm.next;
        }
        dm.next = null;
        return dummy.next;
    }

    /**
     * 虚假的选择排序
     *
     * @param head
     * @return
     */
    public ListNode sortInList2(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            ListNode temp = cur.next;
            while (null != temp) {
                if (cur.val > temp.val) {
                    int tmp = cur.val;
                    cur.val = temp.val;
                    temp.val = tmp;
                }
                temp = temp.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
