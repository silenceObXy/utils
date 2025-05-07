package com.example.utilsdemo.leetcode.array;

import java.util.HashMap;

/**
 * @Author: xy
 * @Date: 2025-04-27 17:12
 * @Description:
 */
public class Solution3392 {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                count++;
            }
        }
        return count;
    }
}
