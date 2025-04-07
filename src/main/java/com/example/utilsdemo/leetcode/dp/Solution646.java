package com.example.utilsdemo.leetcode.dp;

/**
 * @Author: xy
 * @Date: 2024-10-16 15:51
 * @Description:
 */
public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        int length = pairs.length;
        int target = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < length; i++) {
            int num = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                int[] pair = pairs[j];
                int left = pair[0];
                int right = pair[1];
                if (left > target) {
                    num = Math.min(num, right);
                }
            }
            if (num < Integer.MAX_VALUE) {
                result++;
            } else {
                return result;
            }
            target = num;
        }
        return result;
    }
}
