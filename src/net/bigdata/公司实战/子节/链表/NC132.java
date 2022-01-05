/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.链表;

/**
 * Java_rep: NC132 环形链表的约瑟夫问题
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-07 11:06
 * @since 1.2.0, 2021-12-07 11:06
 */

import java.util.LinkedList;

public class NC132 {
    /**
     * @param n int整型
     * @param m int整型
     * @return int整型
     */
    public int ysf(int n, int m) {
        // write code here
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            linkedList.add(i);
        }
        int cur = 0;
        while (linkedList.size() > 1) {
            int size = linkedList.size();
            int removeIndex = (cur + n - 1) % size;//当前要被删除的节点的位置
            linkedList.remove(removeIndex);
            cur = removeIndex % (size - 1);//当前起点的位置。如果删除的是最后一个重置curr为0
        }
        return linkedList.get(0);
    }
}
