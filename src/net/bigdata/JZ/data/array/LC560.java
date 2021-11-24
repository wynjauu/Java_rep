/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.data.array;

import java.util.HashMap;

/**
 * java_20190508: LC560. 和为 K 的子数组
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-20 22:52
 * @since 1.2.0, 2021-11-20 22:52
 */
public class LC560 {
    public int subarraySum(int[] nums, int k) {
        int[] preNums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preNums[i] = preNums[i - 1] + nums[i - 1];
        }

        int req = 0;
        for (int i = 1; i < preNums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preNums[i] - preNums[j] == k) {
                    req++;
                }
            }
        }
        return req;
    }

    /**
     * 优化
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int curNum = 0;
        int req = 0;
        for (int i = 0; i < nums.length; i++) {
            curNum = curNum + nums[i];
            int num = curNum - k;
            if (map.containsKey(num)) {
                req = req + map.get(num);
            }
            map.put(curNum, map.getOrDefault(curNum, 0) + 1);
        }
        return req;
    }
}
