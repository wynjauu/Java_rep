/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Java_rep: NC37 合并区间
 * 排序+ 遍历
 * https://programmercarl.com/0056.%E5%90%88%E5%B9%B6%E5%8C%BA%E9%97%B4.html#%E6%80%BB%E7%BB%93
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-16 00:34
 * @since 1.2.0, 2021-12-16 00:34
 */
public class NC37 {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();

//        Collections.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                if(o1.start == o2.start)return o1.end - o2.end;
//                return o1.start - o2.start;
//            }
//        });
        Collections.sort(intervals, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        int l = -1;
        int r = -1;
        for (Interval val : intervals) {
            int st = val.start;
            int en = val.end;
            if (l == -1) {
                l = st;
                r = en;
            } else if (st <= r) {
                r = Math.max(r, en);
            } else {
                result.add(new Interval(l, r));
                l = st;
                r = en;
            }
        }
        if (l != -1) {
            result.add(new Interval(l, r));
        }
        return result;
    }
}
