/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.贪心;

import java.util.Arrays;

/**
 * Java_rep: NC147 主持人调度
 * https://labuladong.github.io/algo/3/27/100/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-19 23:54
 * @since 1.2.0, 2021-12-19 23:54
 */
public class NC147 {

    /**
     * 遇到红的就是代表一个会议开始+1 -1就是代表前面某一个加了1开始的那个会议结束了 不知道我描述的准不准确，红的说明这个时间点有个新会议，要加一个会议室。
     * 遇到红的就是代表一个会议开始+1 -1就是代表前面某一个加了1开始的那个会议结束了。
     *
     * @param n
     * @param startEnd
     * @return
     */
    public static int minmumNumberOfHost(int n, int[][] startEnd) {
        if (startEnd == null || startEnd[0].length == 0) {
            return 0;
        }
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int count = 0;
        int res = 0;
        while (i < n && j < n) {
            if (start[i] < end[j]) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }
            res = Math.max(count, res);
        }
        return res;
    }

    public static void main(String[] args) {
        //int[][] startEnd = new int[][]{{3, 4}, {1, 2}};
        int[][] startEnd = new int[][]{{2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}};
        minmumNumberOfHost(10, startEnd);
    }
}
