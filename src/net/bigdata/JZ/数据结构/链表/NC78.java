/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.链表;

/**
 * NC78 反转链表
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-04 23:38
 * @since 1.2.0, 2021-11-04 23:38
 */
public class NC78 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 迭代（可以理解为反转head 到 null之间的节点,,左闭右开[head,null)）
     *
     * @param head (1->2->3->4->5)
     * @return 5->4->3->2->1
     */
    public static ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (null != cur) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 返回反转后的头结点
        return pre;
    }


    /**
     * 反转区间 [头a, b) 的元素，注意是左闭右开
     *
     * @param a (1->2->3->4->5)
     * @param b (4->5)
     * @return 3->2->1
     */
    public static ListNode ReverseList(ListNode a, ListNode b) {
        ListNode cur = a;
        ListNode pre = null;
        while (b != cur) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * @param head 1->2->3->4->5
     * @param node 4->5
     * @return 3->2->1->4->5
     */
    public static ListNode ReverseList2(ListNode head, ListNode node) {
        ListNode cur = head;
        ListNode pre = node;
        while (node != cur) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 将链表的前 k 个节点反转（k <= 链表长度）

    /**
     * @param a (1->2->3->4->5)
     * @param k 3
     * @return 3->2->1
     */
    public static ListNode ReverseList(ListNode a, int k) {
        if (null == a) {
            return null;
        }

        ListNode b = a;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return a;
            }
            b = b.next;
        }
        return ReverseList(a, b);
    }


    /**
     * TODO
     * 反转链表递归解法(没理解明白)
     *
     * @param head
     * @return
     */
    public static ListNode solution(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = solution(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        ListNode solution = ReverseList(node1);
//        while (null != solution) {
//            System.out.println(solution.val);
//            solution = solution.next;
//        }
        System.out.println("-----------------");
//        ListNode solution1 = ReverseList(node1, node4);
//        while (null != solution1) {
//            System.out.println(solution1.val);
//            solution1 = solution1.next;
//        }

        ListNode solution1 = ReverseList(node1, 3);
        while (null != solution1) {
            System.out.println(solution1.val);
            solution1 = solution1.next;
        }
    }
}
