package com.example.utilsdemo.leetcode.test;

/**
 * @Author: xy
 * @Date: 2024-10-29 17:07
 * @Description:
 */
public class Solution45 {
    public int jump(int[] nums) {
        int right = nums.length - 1;
        int count = 0;
        while (right > 0) {
            for (int i = 0; i < right; i++) {
                if (i + nums[i] >= right) {
                    right = i;
                    count++;
                }
            }
        }
        return count;
    }
}
