package com.example.utilsdemo.leetcode.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: xy
 * @Date: 2025-03-11 17:34
 * @Description:
 */
public class Solution2012 {
    public static int sumOfBeauties(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }

        int[][] values = new int[len][2];

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - 1 - i]);
            values[i][0] = max;
            values[len - 1 - i][1] = min;
        }



        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            int v = 0;
            if (nums[i] < values[i + 1][1] && nums[i] > values[i - 1][0]) {
                v = 2;
            } else if (nums[i] < nums[i + 1] && nums[i] > nums[i - 1]) {
                v = 1;
            }
            sum += v;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        sumOfBeauties(ints);
    }
}
