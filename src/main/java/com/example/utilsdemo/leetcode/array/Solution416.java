package com.example.utilsdemo.leetcode.array;

import java.util.Arrays;

/**
 * @Author: xy
 * @Date: 2025-04-07 17:36
 * @Description:
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);

        int target = sum / 2;
        int maxNum = nums[n - 1];
        if (maxNum > target) {
            return false;
        }

        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            dp[i][0] = true;
            int num = nums[i];
            for (int j = 0; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}
