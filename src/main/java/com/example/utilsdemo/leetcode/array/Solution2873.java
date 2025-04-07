package com.example.utilsdemo.leetcode.array;

/**
 * @Author: xy
 * @Date: 2025-04-02 09:20
 * @Description:
 */
public class Solution2873 {
    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long[] maxDiff = new long[n];
        //截止到i点，最大差值
        for (int i = n-2; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                maxDiff[i] = Math.max(nums[j] - nums[i], maxDiff[i]);
            }
        }
        long result = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                result = Math.max(result, maxDiff[j] * nums[i]);
            }
        }
        return result;
    }

    public long maximumTripletValue2(int[] nums) {
        int n = nums.length;
        long res = 0, imax = 0, dmax = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, nums[k]);
        }
        return res;
    }
}
