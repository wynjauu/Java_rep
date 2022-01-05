/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Java_rep: NC54 数组中相加和为0的三元组
 * 排序+双指针
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-15 19:59
 * @since 1.2.0, 2021-12-15 19:59
 */
public class NC54 {

    /**
     * 思路：
     * （1）首先对数组进行排序（从小到大）
     * （2）依次取出第 i 个数（i从0开始），并且不重复的选取（跳过重复的数）
     * （3）这样问题就转换为 2 个数求和的问题（可以用双指针解决方法）
     * ==》数求和问题
     * （4）定义两个指针：左指针（left） 和 右指针（right）
     * （5）找出固定 left， 此时left所指的位置为数组中最小数，再找到两个数和 不大于 target 的最大 right 的位置
     * （6）调整 left 的位置（后移），求解和是否为 target O(n)
     * ==》时间复杂度：O(nlogn) + O(n)
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (num == null || num.length < 3) {
            return res;
        }
        Arrays.sort(num);// 排序
        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] > 0) {
                break;// 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }
            if (i > 0 && num[i] == num[i - 1]) {
                continue;// 去重
            }
            int L = i + 1;
            int R = num.length - 1;

            while (L < R) {
                int sum = num[i] + num[L] + num[R];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[L]);
                    list.add(num[R]);
                    res.add(list);
                    while (L < R && num[L] == num[L + 1]) {
                        L++;
                    }
                    while (L < R && num[R] == num[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-10, 0, 10, 20, -10, -40});
    }
}
