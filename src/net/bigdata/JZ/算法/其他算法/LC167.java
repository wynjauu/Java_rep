/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.其他算法;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-31 00:18
 * @since 1.2.0, 2021-10-31 00:18
 */
public class LC167 {

    public int[] solution(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (target > numbers[left] + numbers[right]) {
                left = left + 1;
            } else if (target < numbers[left] + numbers[right]) {
                right = right - 1;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }
}
