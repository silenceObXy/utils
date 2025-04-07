package com.example.utilsdemo.leetcode.dp;

import java.util.HashMap;

/**
 * @Author: xy
 * @Date: 2024-10-11 11:19
 * @Description:
 */
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }


    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            Integer index = map.get(num);
            if (index != null && index != i) {
                result[0] = i;
                result[1] = index;
                return result;
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int last = nums[j];
                if ((first + last) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
