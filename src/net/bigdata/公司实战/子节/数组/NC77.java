/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

/**
 * Java_rep: NC77 调整数组顺序使奇数位于偶数前面(一)
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-18 22:00
 * @since 1.2.0, 2021-12-18 22:00
 */
public class NC77 {
    /**
     * 循环一次
     * 遇到偶数奇数这种组合
     * 就交换位置
     * 然后比较交换后还需不需要继续交换
     *
     * @param array
     * @return
     */
    public int[] reOrderArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            while (i >= 0 && array[i] % 2 == 0 && array[i + 1] % 2 != 0) {
                int temp = array[i + 1];
                array[i + 1] = array[i];
                array[i] = array[temp];
                i--;
            }
        }
        return array;
    }
}
