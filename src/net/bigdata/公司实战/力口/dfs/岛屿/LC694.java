/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.力口.dfs.岛屿;

import java.util.HashSet;

/**
 * Java_rep: LC694. 不同岛屿的数量
 * https://labuladong.github.io/algo/1/7/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-26 17:55
 * @since 1.2.0, 2021-12-26 17:55
 */
public class LC694 {
    int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                dfs(grid, i, j, sb, 0);
                hashSet.add(sb.toString());
            }
        }
        return hashSet.size();
    }

    public void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(dir).append(",");
        dfs(grid, i - 1, j, sb, 1);//上
        dfs(grid, i + 1, j, sb, 2);//下
        dfs(grid, i, j - 1, sb, 3);//左
        dfs(grid, i, j + 1, sb, 4);//右
        sb.append(-dir).append(",");
    }
}
