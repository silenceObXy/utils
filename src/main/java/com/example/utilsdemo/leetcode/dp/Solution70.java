package com.example.utilsdemo.leetcode.dp;

/**
 * @Author: xy
 * @Date: 2024-09-02 15:14
 * @Description:
 */
public class Solution70 {
    public int climbStairs(int n) {
        //f(x) = f(x-1) + f(x-2)
        if (n < 4) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
