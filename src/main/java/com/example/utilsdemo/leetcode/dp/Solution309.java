package com.example.utilsdemo.leetcode.dp;

/**
 * @Author: xy
 * @Date: 2024-10-21 14:12
 * @Description:
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[i] > prices[j]) {
                    if (j > 2) {
                        dp[i] = Math.max(prices[i] - prices[j] + dp[j - 2], dp[i]);
                    } else {
                        dp[i] = Math.max(prices[i] - prices[j], dp[i]);
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[n - 1];
    }


    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n][2];
        f[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]);
            f[i][1] = Math.max(f[i - 1][1], (i > 1 ? f[i - 2][0] : 0) - prices[i]);
        }
        return f[n - 1][0];
    }
}
