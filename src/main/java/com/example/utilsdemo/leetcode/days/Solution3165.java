package com.example.utilsdemo.leetcode.days;

/**
 * @Author: xy
 * @Date: 2024-10-31 17:22
 * @Description:
 */
public class Solution3165 {
    public static int maximumSumSubsequence(int[] nums, int[][] queries) {
        if (nums.length == 0) {
            return 0;
        }
        int n = queries.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            nums[index] = value;
            int v = getMax(nums);
            max += v;
        }
        return max%(1000000000 + 7);
    }

    public static int getMax(int[] nums) {
        //利用动态规划的思想去取最大值
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = Math.max(0, nums[0]);
        if (n == 1) {
            return dp[0];
        }
        dp[1] = Math.max(0, nums[1]);
        if (n == 2) {
            return Math.max(dp[0], dp[1]);
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[j] + Math.max(0, nums[i]), dp[i]);
            }
        }
        return Math.max(dp[n-2], dp[n-1]);
    }


    public static void main(String[] args) {
        int[] ints = {3, -3, 3, -1, -3, 2, -1};
        int[][] queries = {{2, -1}, {2, 3}, {4, 3}, {2, 1}, {4, 3}, {6, -3}, {1, 0}, {2, 3}};
        maximumSumSubsequence(ints, queries);
    }
}
