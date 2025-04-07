package com.example.utilsdemo.leetcode.doubleIndex;

/**
 * @Author: xy
 * @Date: 2024-11-08 09:36
 * @Description:
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int n = numbers.length;
        int left = 0;
        int right = n-1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                ans[0] = left+1;
                ans[1] = right+1;
                return ans;
            } else if (sum > target) {
                right--;
            } else  {
                left++;
            }
        }
        return ans;
    }
}
