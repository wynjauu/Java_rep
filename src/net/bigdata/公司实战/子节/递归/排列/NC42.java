/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.递归.排列;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Java_rep: NC42 有重复项数字的所有排列
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-09 23:26
 * @since 1.2.0, 2021-12-09 23:26
 */
public class NC42 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);//先排序,使重复的数字相邻
        dfs(num, 0);
        return res;
    }

    public void dfs(int[] num, int index) {
        if (index == num.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < num.length; i++) {
                temp.add(num[i]);
            }
            if (!res.contains(temp)) {
                res.add(temp);
            }
        }
        for (int i = index; i < num.length; i++) {
            if (i > index && num[i] == num[index]) {
                continue;//剪枝，i位置和index位置相等则排列相同不用走了
            }
            swap(num, index, i);
            dfs(num, index + 1);
            swap(num, index, i);
        }
    }

    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
