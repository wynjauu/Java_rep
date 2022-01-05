/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.模拟;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Java_rep: NC94 设计LFU缓存结构
 * https://mp.weixin.qq.com/s/oXv03m1J8TwtHwMJEZ1ApQ
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-20 16:50
 * @since 1.2.0, 2021-12-20 16:50
 */
public class NC94 {
    public class LFUCache {
        private HashMap<Integer, Integer> key2Value;
        private HashMap<Integer, Integer> key2Fre;
        private HashMap<Integer, LinkedHashSet<Integer>> fre2Keys;
        // 记录最小的频次
        int minFreq;
        int catacity;

        public LFUCache(int size) {
            key2Value = new HashMap<>();
            key2Fre = new HashMap<>();
            fre2Keys = new HashMap<>();
            this.catacity = size;
        }


        public void set(int k, int v) {
            if (key2Value.containsKey(k)) {
                key2Value.put(k, v);
                int freq = key2Fre.get(k);
                /* 更新 KF 表 */
                key2Fre.put(k, freq + 1);
                /* 更新 FK 表 */
                // 将 key 从 freq 对应的列表中删除
                fre2Keys.get(freq).remove(k);
                // 将 key 加入 freq + 1 对应的列表中
                fre2Keys.putIfAbsent(freq + 1, new LinkedHashSet<>());
                fre2Keys.get(freq + 1).add(k);
                // 如果 freq 对应的列表空了，移除这个 freq
                if (fre2Keys.get(freq).isEmpty()) {
                    fre2Keys.remove(freq);
                    // 如果这个 freq 恰好是 minFreq，更新 minFreq
                    if (freq == this.minFreq) {
                        this.minFreq++;
                    }
                }
                return;
            }

            //满了，需要删除，在添加
            if (key2Value.size() >= catacity) {
                // freq 最小的 key 列表
                LinkedHashSet<Integer> keyList = fre2Keys.get(this.minFreq);
                // 其中最先被插入的那个 key 就是该被淘汰的 key
                int deletedKey = keyList.iterator().next();
                /* 更新 FK 表 */
                keyList.remove(deletedKey);
                if (keyList.isEmpty()) {
                    fre2Keys.remove(this.minFreq);
                    // 问：这里需要更新 minFreq 的值吗？
                }
                /* 更新 KV 表 */
                key2Value.remove(deletedKey);
                /* 更新 KF 表 */
                key2Fre.remove(deletedKey);
            }
            key2Value.put(k, v);
            key2Fre.put(k, 1);
            fre2Keys.putIfAbsent(1, new LinkedHashSet<>());
            fre2Keys.get(1).add(k);
            // 插入新 key 后最小的 freq 肯定是 1
            this.minFreq = 1;
        }

        public int get(int k) {
            if (!key2Value.containsKey(k)) {
                return -1;
            }

            int fre = key2Fre.get(k);
            int incFre = fre + 1;
            key2Fre.put(k, incFre);

            //删除fre
            LinkedHashSet<Integer> keys = fre2Keys.get(fre);
            keys.remove(k);
            //如果此时fre2Keys中，fre的key没有value，删除空的LinkedHashSet的
            if (fre2Keys.get(fre).isEmpty()) {
                fre2Keys.remove(fre);
                // 如果这个 freq 恰好是 minFreq，更新 minFreq
                if (fre == this.minFreq) {
                    this.minFreq++;
                }
            }

            // 将 key 加入 freq + 1 对应的列表中
            fre2Keys.putIfAbsent(incFre, new LinkedHashSet<>());
            fre2Keys.get(incFre).add(k);

            return key2Value.get(k);

        }

    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        int dd = map.get(1) + 1;
        System.out.println(map.get(1));
    }
}
