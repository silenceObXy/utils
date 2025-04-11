package com.example.utilsdemo.leetcode.array;

/**
 * @Author: xy
 * @Date: 2025-04-08 10:24
 * @Description:
 */
public class Solution518 {
    public static int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        int coin1 = coins[0];
        dp[0][coin1] = 1;
        for (int i = coin1 + 1; i <= amount; i++) {
            dp[0][i] = dp[0][i - coin1];
        }
        for (int i = 1; i < n; i++) {
            int coin = coins[i];
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] += dp[i][j - coin];
                } else {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][amount];
    }

    public static void main(String[] args) {
        int[] ints = {1,2,5};
        change(5, ints);
    }
}
