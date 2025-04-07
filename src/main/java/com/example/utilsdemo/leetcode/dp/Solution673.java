package com.example.utilsdemo.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: xy
 * @Date: 2024-10-14 14:22
 * @Description:
 */
public class Solution673 {
    public static int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int max = 1;
        int[] dp = new int[length];
        int[] num = new int[length];
        Arrays.fill(dp, 1);
        Arrays.fill(num, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 == dp[i]) {
                        num[i] += num[j];
                    } else if (dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        num[i] = num[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            int value = dp[i];
            if (value == max) {
                //结算
                result += num[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,4,3,5,4,7,2};
        int number = findNumberOfLIS(ints);
        System.out.println(number);
    }
}
