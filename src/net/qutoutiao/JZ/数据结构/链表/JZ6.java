/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.JZ.数据结构.链表;


import java.util.ArrayList;

/**
 * JZ6 从尾到头打印链表
 * 参考：https://www.cnblogs.com/helloHKTK/p/11630919.html
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-20 22:51
 * @since 1.2.0, 2021-10-20 22:51
 */


public class JZ6 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 方法1：循环
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> solution(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode head = listNode;
        while (null != head) {
            result.add(0, head.val);
            head = head.next;
        }
        return result;
    }

    /**
     * 方法2：入栈，出栈
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> solution2(ListNode listNode) {
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        ListNode head = listNode;
        while (null != head) {
            stack.add(head.val);
            head = head.next;
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            result.add(stack.get(i));
        }
        return result;
    }


    /**
     * 方法3：递归(牛客网一直通过不了？？？)
     *
     * @param listNode
     * @return
     */
    //注意：因为要用递归，存放结果的list要放在外面
    ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> solution3(ListNode listNode) {
        ListNode head = listNode;
        if (null != head) {
            solution2(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }


}
