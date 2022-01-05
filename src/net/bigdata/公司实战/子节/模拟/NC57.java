/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.模拟;

/**
 * Java_rep: NC57 反转数字
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-20 19:35
 * @since 1.2.0, 2021-12-20 19:35
 */
public class NC57 {
    public static int reverse(int x) {
        // write code here
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;//有可能x反装后大于int类型
    }

    public static void main(String[] args) {
        int test = reverse(2123456789);
    }
}
