package com.example.utilsdemo.leetcode.dp;

/**
 * @Author: xy
 * @Date: 2024-10-12 17:01
 * @Description:
 */
public class Solution300 {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,10,4,3,8,9};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }
}
