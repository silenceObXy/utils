package com.example.utilsdemo.leetcode.dp;

/**
 * @Author: xy
 * @Date: 2025-02-25 09:39
 * @Description:
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < len; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
