package com.example.utilsdemo.leetcode.array;

import java.util.HashSet;

/**
 * @Author: xy
 * @Date: 2025-04-08 10:10
 * @Description:
 */
public class Solution3396 {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int index = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            if (set.contains(num)) {
                index = i + 1;
                break;
            }
            set.add(num);
        }
        return index % 3 == 0 ? index / 3 : index / 3 + 1;
    }
}
