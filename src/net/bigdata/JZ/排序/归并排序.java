/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.排序;

/**
 * Java_rep: 归并排序
 * https://www.cnblogs.com/chengxiao/p/6194356.html
 * https://www.runoob.com/w3cnote/merge-sort.html
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-18 13:15
 * @since 1.2.0, 2021-12-18 13:15
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        for (int a : arr) {
            System.out.print(a);
        }
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
        int l = left;//左侧数组指针，开始的时候指向左侧第一个元素
        int r = mid + 1;//右侧数组指针，开始的时候指向右侧第一个元素

        int i = 0;//临时数组指针
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[i++] = arr[l++];
            } else {
                temp[i++] = arr[r++];
            }
        }

        //如果左边还有剩余，把剩余的追加到后面
        while (l <= mid) {
            temp[i++] = arr[l++];
        }
        //如果右边还有剩余，把剩余的追加到后面
        while (r <= right) {
            temp[i++] = arr[r++];
        }

        //将临时的temp数组元素覆盖到对应范围内的arr里面
        i = 0;
        while (left <= right) {
            arr[left++] = temp[i++];
        }
    }
}
