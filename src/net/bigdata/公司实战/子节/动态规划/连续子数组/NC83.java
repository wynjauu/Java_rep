/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.动态规划.连续子数组;

/**
 * Java_rep: NC83 连续子数组最大乘积
 * 对比：NC19 连续子数组的最大和
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-18 20:11
 * @since 1.2.0, 2021-12-18 20:11
 */
public class NC83 {

    /**
     * 又是一个求连续区间数组的问题，典型的动态规划问题：
     * 跟求最大区间和不同的是，如果我们依然使用dp[i]表示a[i]结尾的子区间的最大乘积，会发现由于负数的存在，会导致乘法结果反转。
     * dp[i-1]*a[i]反倒变成了最小值，无法得到状态转移方程。
     * 沿着乘法的特性看，如果a[i]为负数，那么dp*a[i]时候，dp越小结果越小，dp越小结果越大。所以，我们只需要同时保持最大值和最小值，就可以写状态转移方程了。
     * a[i]>0时：
     * maxDp[i] = max(a[i],a[i]*maxDp[i-1]);
     * mixDp[i] = mix(a[i],a[i]*mixDp[i-1]);
     * a[i]<0时：
     * maxDp[i] = max(a[i],a[i]*mixDp[i-1]);
     * mixDp[i] = max(a[i],a[i]*maxDp[i-1]);
     * a[i]=0时，max和min都是0
     *
     * @param arr
     * @return
     */
    public static double maxProduct(double[] arr) {
        if (null == arr || arr.length == 0) {
            return 0D;
        }
        int n = arr.length;
        double[] minDp = new double[n];
        double[] maxDp = new double[n];
        minDp[0] = arr[0];
        maxDp[0] = arr[0];
        double max = maxDp[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                minDp[i] = Math.min(arr[i], arr[i] * maxDp[i - 1]);
                maxDp[i] = Math.max(arr[i], arr[i] * minDp[i - 1]);
            } else if (arr[i] > 0) {
                minDp[i] = Math.min(arr[i], arr[i] * minDp[i - 1]);
                maxDp[i] = Math.max(arr[i], arr[i] * maxDp[i - 1]);
            }
            max = Math.max(max, maxDp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        double val = maxProduct(new double[]{0.5, 0.3, 4.0});
        System.out.println(val);
    }
}
