package com.example.utilsdemo.leetcode.array;

/**
 * @Author: xy
 * @Date: 2025-04-01 11:19
 * @Description:
 */
public class Solution2140 {
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[][] dp = new long[n][2];
        dp[0][1] = questions[0][0];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            int index = i - 1;
            while (index >= 0) {
                int diff = i - index;
                int limit = questions[index][1];
                if (limit < diff) {
                    break;
                }
                index--;
            }
            dp[i][1] = index == -1 ? questions[i][0] : Math.max(dp[index][0], dp[index][1]) + questions[i][0];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    public long mostPoints2(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[Math.min(n, i + questions[i][1] + 1)]);
        }
        return dp[0];
    }


    public static void main(String[] args) {
        int[][] ints = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        mostPoints(ints);
    }
}
