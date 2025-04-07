package com.example.utilsdemo.leetcode.dp;

/**
 * @Author: xy
 * @Date: 2025-04-01 17:27
 * @Description:
 */
public class Solution279 {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
