/*
 * Copyright © 2018-2021 me.100.
 *
 * This file is part of Java_rep project.
 * It can not be copied and/or distributed without the express
 * permission of bigdata group.
 */
package net.bigdata.公司实战.子节.数组;

/**
 * Java_rep: NC22 合并两个有序的数组
 *
 * @author wuyang
 * @version 1.2.0, 2021-12-15 15:23
 * @since 1.2.0, 2021-12-15 15:23
 */
public class NC22 {
    public void merge(int A[], int m, int B[], int n) {
        int aIdx = 0;
        int bInx = 0;

        if (m == 0) {
            while (bInx < n) {
                A[aIdx++] = B[bInx++];
            }
            return;
        }

        while (aIdx < m && bInx < n) {
            if (A[aIdx] <= B[bInx]) {
                aIdx++;
            } else {
                helper(A, aIdx, B[bInx]);
                bInx++;
                aIdx++;
                m++;
            }
        }
        while (bInx < n) {
            A[aIdx++] = B[bInx++];
        }
    }

    public void helper(int A[], int startIdx, int num) {
        for (int i = A.length - 2; i >= startIdx; i--) {
            A[i + 1] = A[i];
        }
        A[startIdx] = num;
    }
}
