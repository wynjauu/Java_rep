/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.双指针;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Java_rep: NC82 滑动窗口的最大值
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-18 22:46
 * @since 1.2.0, 2021-12-18 22:46
 */
public class NC82 {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        PriorityQueue<Integer> window = new PriorityQueue<>((o1, o2) -> o2 - o1);

        ArrayList<Integer> list = new ArrayList<>();
        if (size > num.length || size == 0) {
            return list;
        }
        //LinkedList<Integer> window = new LinkedList<>();

        int right = 0;
        int left = 0;
        while (right <= num.length - 1) {
            int c = num[right];
            if (window.size() != size) {
                window.offer(c);
                right++;
            }

            if (window.size() == size) {
//                int max = maxVal(window);
//                list.add(max);
//                window.removeFirst();
                list.add(window.peek());
                window.remove(num[left]);
                left++;
            }
        }
        return list;
    }

    public static int maxVal(LinkedList<Integer> queues) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < queues.size(); i++) {
            max = Math.max(queues.get(i), max);
        }
        return max;
    }


    public static ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size > num.length || size == 0) {
            return list;
        }
        int right = 0;
        int left = 0;
        while (right < num.length - 1) {
            if (right - left + 1 != size) {
                right++;
            }

            if (right - left + 1 == size) {
                int max = Integer.MIN_VALUE;
                for (int i = left; i <= right; i++) {
                    max = Math.max(max, num[i]);
                }
                list.add(max);
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        maxInWindows1(new int[]{10, 14, 12, 11}, 4);
    }
}
