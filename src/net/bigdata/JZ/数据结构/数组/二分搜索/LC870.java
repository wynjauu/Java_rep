/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组.二分搜索;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Java_rep: LC870. 优势洗牌
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-27 00:15
 * @since 1.2.0, 2021-11-27 00:15
 */
public class LC870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); //升序

        PriorityQueue<int[]> nums2Queue = new PriorityQueue<>(nums2.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < nums2.length; i++) {
            nums2Queue.offer(new int[]{i, nums2[i]});
        }

        int[] result = new int[nums1.length];
        int start = 0;
        int end = nums1.length - 1;
        while (!nums2Queue.isEmpty()) {
            int[] poll = nums2Queue.poll();
            int index = poll[0];
            int num2Value = poll[1];
            if (num2Value < nums1[end]) {
                result[index] = nums1[end];
                end--; //因为end位置的元素已经使用了
            } else {
                result[index] = nums1[start];
                start++; //因为start位置的元素已经使用了
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 1};
        int[] nums2 = new int[]{2, 4, 1, 6, 3};
        //Arrays.sort(array);

        PriorityQueue<int[]> nums2Queue = new PriorityQueue<>(nums2.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < nums2.length; i++) {
            nums2Queue.offer(new int[]{i, nums2[i]});
        }

        System.out.println(nums2Queue.poll()[1]);
        System.out.println(nums2Queue.poll()[1]);
        System.out.println(nums2Queue.poll()[1]);
    }
}
