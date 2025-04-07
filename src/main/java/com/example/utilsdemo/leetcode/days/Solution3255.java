package com.example.utilsdemo.leetcode.days;

/**
 * @Author: xy
 * @Date: 2024-11-07 17:51
 * @Description:
 */
public class Solution3255 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            count = i == 0 || nums[i] - nums[i-1] != 1 ? 1: count+1;
            if (count > k) {
                ans[n - k +1] = nums[i];
            }
        }
        return ans;
    }
}
