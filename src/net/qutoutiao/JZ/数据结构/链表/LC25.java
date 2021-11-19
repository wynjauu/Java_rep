/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.JZ.数据结构.链表;

/**
 * java_20190508: LC25. K 个一组翻转链表
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-07 14:53
 * @since 1.2.0, 2021-11-07 14:53
 */
public class LC25 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        //ListNode nxt;
        // while 终止的条件改一下就行了
        while (cur != b) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);   //(3->4->5,5)=> 4->3            (1->2->3->4->5,3->4->5)=> 2->1
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);     //a=3,,,a.next=(5,2)=> a=3->5     a=1,,,a.next=(3->4->5,2)=> a=1->4->3
        return newHead;                  //4->3->5      2->1->4->3->5
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        //node3.next = node4;
        //node4.next = node5;

        ListNode solution1 = reverseKGroup(node1, 2);
//        ListNode solution1 = reverse(node1, node4);
        while (null != solution1) {
            System.out.println(solution1.val);
            solution1 = solution1.next;
        }
    }
}
