/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.排序;

import java.util.Arrays;

/**
 * Java_rep: NC140 排序
 * 各种排序优缺点：https://blog.csdn.net/jiajing_guo/article/details/69388331
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-19 11:43
 * @since 1.2.0, 2021-12-19 11:43
 */
public class NC140 {
    //归并排序 时间：O(nlogn) 空间：O(n)
    public static int[] MySort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        return arr;
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;

        int i = 0;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[i++] = arr[l++];
            } else {
                temp[i++] = arr[r++];
            }
        }

        while (l <= mid) {
            temp[i++] = arr[l++];
        }

        while (r <= right) {
            temp[i++] = arr[r++];
        }

        i = 0;
        while (left <= right) {
            arr[left++] = temp[i++];
        }
    }

    //快速排
    public static int[] MySort2(int[] arr) {
        kuaisu(arr, 0, arr.length - 1);
        return arr;
    }

    public static void kuaisu(int[] arr, int left, int right) {
        if (left < right) {
            int l = left;
            int r = right;
            int x = arr[l];
            while (l < r) {
                while (l < r && arr[r] > x) {
                    r--;
                }
                if (l < r) {
                    arr[l++] = arr[r];
                }
                while (l < r && arr[l] < x) {
                    l++;
                }
                if (l < r) {
                    arr[r--] = arr[l];
                }
            }
            arr[l] = x;
            kuaisu(arr, left, l - 1);
            kuaisu(arr, l + 1, right);
        }
    }

    //堆排序

    //test
    public static void main(String[] args) {
        int[] guibing = MySort2(new int[]{5, 2, 3, 1, 4});
        Arrays.stream(guibing).forEach(System.out::println);
    }
}
