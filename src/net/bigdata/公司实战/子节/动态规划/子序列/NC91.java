/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.子序列;

import java.util.ArrayList;

/**
 * Java_rep: NC91 最长上升子序列(三)
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-10 16:33
 * @since 1.2.0, 2021-12-10 16:33
 */
//动态规划+二分查找
public class NC91 {
    public static int[] LIS(int[] arr) {
        // write code here
        int n = arr.length;
        int[] dp = new int[n];

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int num = arr[i];
            if (num > list.get(list.size() - 1)) {
                list.add(num);
                dp[i] = list.size();
            } else {
                //二分法将c替换cur数组里面去
                int left = 0;
                int right = list.size() - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                list.set(left, num);
                dp[i] = left + 1;
            }
        }

        int count = list.size();
        int[] result = new int[count];
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] == count) {
                result[--count] = arr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
