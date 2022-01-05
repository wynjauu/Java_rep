/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Java_rep: NC27 集合的所有子集(一)
 * https://labuladong.github.io/algo/4/29/107/
 * https://mp.weixin.qq.com/s/qT6WgR6Qwn7ayZkI3AineA
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-16 21:14
 * @since 1.2.0, 2021-12-16 21:14
 */
public class NC27 {

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    static List<Integer> list = new LinkedList<>();

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        dfs(S, 0);
        return ans;
    }

    static void dfs(int[] nums, int index) {
        ans.add(new ArrayList(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }
}
