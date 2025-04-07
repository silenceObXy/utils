package com.example.utilsdemo.leetcode.window;

/**
 * @Author: xy
 * @Date: 2024-11-04 16:39
 * @Description:
 */
public class Solution209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            while (sum > target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int i = minSubArrayLen(11, nums);
        System.out.println(i);
    }
}
