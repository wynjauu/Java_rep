/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC24 删除有序链表中重复的元素-II
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-06 23:36
 * @since 1.2.0, 2021-12-06 23:36
 */
public class NC24 {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 一次遍历：时间复杂度O(n),空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;

        //前一个元素
        ListNode left = head;
        //后一个元素
        ListNode right = head.next;
        //记录重复的元素是什么
        int cache = Integer.MIN_VALUE;

        while (right != null) {
            //如果存在前一个元素和后一个元素相同的情况，记录下来当前元素的值
            if (left.val == right.val) {
                cache = left.val;
                //当pre指针不是重复的值的时候，才能让哨兵指向他
                //假设1，2，2，3，如果只通过pre和next不重复判断，当2，3不重复的时候，哨兵指向2
            } else if (cache != left.val) {
                node.next = left;
                node = node.next;
            }
            right = right.next;
            left = left.next;
        }
        //这里不太好理解：
        //假设是1，2，2，3这样的情况，
        //上述循环的终止是pre在3上，next为null，此刻3不是重复值，但是哨兵并没有指向它，会造成3的丢失
        //假设是1，2，2
        //上述循环的终止是pre在2上，next为null，此刻2是重复值，哨兵得指向null
        //因为哨兵第一次指向的是1，但是1没有断开和2，2的连线，当下一次循环的时候哨兵是1了，但是2，2重复了
        //所以node.next=null是为了断开末尾重复的情况
        if (cache != left.val) {
            node.next = left;
        } else {
            node.next = null;
        }
        return dummy.next;
    }
}
