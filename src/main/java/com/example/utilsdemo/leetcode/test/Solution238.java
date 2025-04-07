package com.example.utilsdemo.leetcode.test;

/**
 * @Author: xy
 * @Date: 2024-10-30 17:47
 * @Description:
 */
public class Solution238 {
    public static int[] productExceptSelf(int[] nums) {
        int num = 1;
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            num = num * nums[i];
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int v = 1;
                for (int j = 0; j < len; j++) {
                    if (i != j) {
                        v = v * nums[j];
                    }
                }
                result[i] = v;
            } else {
                result[i] = num / nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[]{-1, 1, 0, -3, 3});
    }
}
