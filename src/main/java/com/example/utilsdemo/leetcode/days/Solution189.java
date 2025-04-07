package com.example.utilsdemo.leetcode.days;

/**
 * @Author: xy
 * @Date: 2024-08-30 10:23
 * @Description:
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int n = k % length;
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = nums[length + i -n];
        }
        for (int j = length - 1; j >= n; j--) {
            nums[j] = nums[j - n];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ints[i];
        }
    }
}
