package com.example.utilsdemo.leetcode.test;

/**
 * @Author: xy
 * @Date: 2024-10-29 15:17
 * @Description:
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        int l = 0;
        for (int i = 0; i <= l; i++) {
            if (l >= len - 1) {
                return true;
            }
            l = Math.max(l, i + nums[i]);
        }
        return false;
    }
}
