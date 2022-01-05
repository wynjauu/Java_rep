/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.力口.dfs.岛屿;

/**
 * Java_rep: LC695. 岛屿的最大面积
 * https://labuladong.github.io/algo/1/7/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-26 16:05
 * @since 1.2.0, 2021-12-26 16:05
 */
public class LC695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if (grid == null || grid[0].length == 0) {
            return res;
        }
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        return dfs(grid, i + 1, j)
                + dfs(grid, i - 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i, j - 1) + 1;
    }
}
