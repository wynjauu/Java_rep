/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串.滑动窗口;

import java.util.HashMap;

/**
 * Java_rep: NC28 最小覆盖子串
 * https://labuladong.github.io/algo/2/21/56/
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-14 21:26
 * @since 1.2.0, 2021-12-14 21:26
 */
public class NC28 {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        //初始化 window 和 need 两个哈希表，记录窗口中的字符和需要凑齐的目标字符
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;


        //滑动窗口区间 [left, right)
        int left = 0;
        int right = 0;
        int valid = 0;//valid 变量表示窗口中满足 need 条件的字符个数，如果 valid 和 need.size 的大小相同，则说明窗口已满足条件，已经完全覆盖了串 T。
        while (right <= S.length() - 1) {
            /** 增大窗口 **/
            //c 是将移入窗口的字符
            char c = S.charAt(right);
            right++;// 右移窗口

            // 进行窗口内数据的一系列更新,先判断c是否是需要的字符
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) { //判断窗口c个数是否跟目标字符个数一样，一样的话说明合格了
                    valid++;
                }
            }

            /** 缩小窗口**/
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 先判断是否比一起的字串短，在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                //c1 是将移入窗口的字符
                char c1 = S.charAt(left);
                // 左移窗口
                left++;

                // 进行窗口内数据的一系列更新
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.get(c1)-1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : S.substring(start, start + len);
    }
}
