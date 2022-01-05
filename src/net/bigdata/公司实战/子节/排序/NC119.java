/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.排序;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Java_rep: NC119 最小的K个数
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-19 15:24
 * @since 1.2.0, 2021-12-19 15:24
 */
public class NC119 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0) {
            return list;
        }
        if (k >= input.length) {
            Arrays.stream(input).forEach(v -> list.add(v));
            return list;
        }
        sort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void sort(int[] input, int left, int right) {
        if (left < right) {
            int l = left;
            int r = right;
            int x = input[l];
            while (l < r) {
                while (l < r && input[r] > x) {
                    r--;
                }
                if (l < r) {
                    input[l++] = input[r];
                }
                while (l < r && input[l] < x) {
                    l++;
                }
                if (l < r) {
                    input[r--] = input[l];
                }
            }
            input[l] = x;
            sort(input, left, l - 1);
            sort(input, l + 1, right);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = GetLeastNumbers_Solution(new int[]{234, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233, 233}, 10);
    }
}
