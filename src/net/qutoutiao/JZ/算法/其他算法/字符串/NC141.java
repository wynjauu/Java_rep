/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.qutoutiao.JZ.算法.其他算法.字符串;

/**
 * NC141 判断是否为回文字符串
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-11-08 23:30
 * @since 1.2.0, 2021-11-08 23:30
 */
public class NC141 {

    public boolean judge(String str) {
        // write code here
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
