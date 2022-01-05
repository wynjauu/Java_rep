/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Java_rep: NC51 合并k个已排序的链表
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 17:38
 * @since 1.2.0, 2021-12-06 17:38
 */
public class NC51 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法一：两两合并
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (null == lists || lists.size() == 0) {
            return null;
        }
        ListNode head = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            head = merge2ListNode(head, lists.get(i));
        }
        return head;
    }

    public ListNode merge2ListNode(ListNode node1, ListNode node2) {
        if (null == node1) {
            return node2;
        }

        if (null == node2) {
            return node1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        ListNode n1 = node1;
        ListNode n2 = node2;
        while (null != n1 && null != n2) {
            if (n1.val > n2.val) {
                p.next = n2;
                n2 = n2.next;
                p = p.next;
            } else {
                p.next = n1;
                n1 = n1.next;
                p = p.next;
            }
        }
        if (null != n1) {
            p.next = n1;
        }
        if (null != n2) {
            p.next = n2;
        }
        return dummy.next;
    }

    /**
     * 方法二：优先队列
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        if (null == lists || lists.size() == 0) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.size(), (o1, o2) -> {
            return o1.val - o2.val;
        });

        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.offer(listNode);
            }
        }

        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (!priorityQueue.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode poll = priorityQueue.poll();
            p.next = poll;
            p = p.next;
            if (null != poll.next) {
                priorityQueue.add(poll.next);
            }
        }
        return dummy.next;
    }
}
