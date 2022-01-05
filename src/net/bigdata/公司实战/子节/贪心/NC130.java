/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.贪心;

/**
 * Java_rep: NC130 分糖果问题
 * https://programmercarl.com/0135.%E5%88%86%E5%8F%91%E7%B3%96%E6%9E%9C.html#%E6%80%9D%E8%B7%AF
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-19 22:56
 * @since 1.2.0, 2021-12-19 22:56
 */
public class NC130 {
    public int candy(int[] arr) {
        // write code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[] candy = new int[n];
        candy[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            if (arr[j] > arr[j + 1]) {
                candy[j] = Math.max(candy[j], candy[j + 1] + 1);
            } else {
                candy[j] = Math.max(candy[j], 1);
            }
        }

        int res = 0;
        for (int val : candy) {
            res += val;
        }
        return res;
    }
}
