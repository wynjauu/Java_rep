/*
 * Copyright © 2013-2021 qutoutiao.net.
 *
 * This file is part of java_20190508 project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.JZ.算法.其他算法;

/**
 * 344. 反转字符串
 *
 * @author wuyang (Employee ID: )
 * @version 1.2.0, 2021-10-31 00:31
 * @since 1.2.0, 2021-10-31 00:31
 */
public class NC103_LC344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char dummy = s[left];
            s[left] = s[right];
            s[right] = dummy;
            left++;
            right--;
        }
    }

    /**
     * NC103 反转字符串
     *
     * @param str
     * @return
     */
    public String reverseString(String str) {
        // write code here
        if (null == str) {
            return str;
        }

        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[right];
            charArray[right] = charArray[left];
            charArray[left] = temp;
            left++;
            right--;
        }

        return String.valueOf(charArray);
    }
}
