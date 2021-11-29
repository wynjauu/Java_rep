/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.数据结构.数组;

import java.util.HashMap;

/**
 * Java_rep: LC710. 黑名单中的随机数
 *
 * @author wuyang
 * @version 1.2.0, 2021-11-27 16:12
 * @since 1.2.0, 2021-11-27 16:12
 */
public class LC710 {
    //将blacklist名单移动到map后面，随机[0,sz]即可满足题意
    HashMap<Integer, Integer> map;
    int sz;

    public LC710(int n, int[] blacklist) {

        map = new HashMap();
        //最终数组的元素个数
        sz = n - blacklist.length;
        //将所有的黑名单加入map
        for (int b : blacklist) {
            //赋值随意即可，目的把键值存入哈希表
            //判断数字是否在黑名单内
            map.put(b, 666);
        }
        int last = n - 1;
        for (int b : blacklist) {
            //如果b已经在[sz,N],可以忽略
            if (b >= sz) {
                continue;
            }
            //跳过所有的黑名单数字
            while (map.containsKey(last)) {
                last--;
            }
            //将黑名单索引放最后
            map.put(b, last);
            last--;
        }
    }

    public int pick() {
        int k = (int) (Math.random() * sz);
        return map.getOrDefault(k, k);
    }

}
