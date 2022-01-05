/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC133 链表的奇偶重排
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 00:32
 * @since 1.2.0, 2021-12-07 00:32
 */
public class NC133 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 原地算法
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        //无需对头节点做操作 不用dummyHead
        //奇链表头位于head 偶链表头位于head.next
        ListNode oddHead = head, evenHead = head.next;
        ListNode odd = oddHead, even = evenHead;
        //终止条件：因为even走在前面 一定先终止 所以判断条件就是它
        //节点总数为偶数个时 even.next为null
        //节点总数为奇数个时： even==null  这俩条件触发一个就跳出循环
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        //奇偶链表拼接
        odd.next = evenHead;
        return head; //因为oddHead 和evenHead 是指针都是在head上原地操作的，所以要返回head
    }

}
