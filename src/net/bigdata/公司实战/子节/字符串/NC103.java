/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.字符串;

/**
 * Java_rep: NC103 反转字符串
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-11 23:25
 * @since 1.2.0, 2021-12-11 23:25
 */
public class NC103 {
    public String solve(String str) {
        // write code here
        if (null == str || str.length() == 0) {
            return str;
        }
        int left = 0;
        int right = str.length() - 1;

        StringBuilder sb = new StringBuilder(str);
        while (left <= right) {
            char c = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, c);
            left++;
            right--;
        }
        return sb.toString();
//         char[] arr = str.toCharArray();
//         while(left <= right){
//             char c = arr[left];
//             arr[left] = arr[right];
//             arr[right] = c;
//             left++;
//             right--;
//         }
//         return new String(arr);
    }
}
