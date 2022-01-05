/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.递归.回溯;

import java.util.ArrayList;

/**
 * Java_rep: NC43 没有重复项数字的所有排列
 * https://labuladong.github.io/algo/4/29/105/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-16 14:52
 * @since 1.2.0, 2021-12-16 14:52
 */
public class NC43 {

    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<Integer> track = new ArrayList<>();
        dfs(num, track);
        return res;
    }

    //路径：记录在track里面
    //选择列表：num 中不存在 track中的那些元素
    //结束条件：num 中元素全部都在track中了
    public static void dfs(int[] num, ArrayList<Integer> track) {
        // 触发结束条件
        if (num.length == track.size()) {
            res.add(new ArrayList<>(track));//因为后面取消会删除对象应用导致res里面也删除了
            return;
        }

        for (int i = 0; i < num.length; i++) {
            //排除不合法的选择
            if (track.contains(num[i])) {
                continue;
            }
            // 做选择
            track.add(num[i]);
            // 进入下一层决策树
            dfs(num, track);
            // 取消选择
            track.remove(track.size() - 1); //因为这边的取消会删除对象应用导致res里面也删除了
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> test = permute(new int[]{1});
        System.out.println(test);
    }
}
