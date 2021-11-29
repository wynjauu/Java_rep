/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.链表;

/**
 * JZ25=LC21 合并两个排序的链表
 * 牛客网通过了
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-22 21:59
 * @since 1.2.0, 2021-10-22 21:59
 */
public class JZ25_LC21 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 「虚拟头结点」技巧
     * 迭代
     * 运行时间：143ms
     * 超过0.58% 用Java提交的代码
     * 占用内存：17296KB
     * 超过1.20%用Java提交的代码
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution(ListNode list1, ListNode list2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }

    /**
     * 递归 比 迭代性能好
     * 运行时间：134ms
     * 超过1.24% 用Java提交的代码
     * 占用内存：15408KB
     * 超过13.76%用Java提交的代码
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode solution2(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = solution2(list1, list2.next);
            return list2;
        } else {
            list1.next = solution2(list1.next, list2);
            return list1;
        }
    }
}
