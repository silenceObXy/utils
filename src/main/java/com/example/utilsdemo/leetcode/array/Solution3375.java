package com.example.utilsdemo.leetcode.array;

import java.util.HashSet;

/**
 * @Author: xy
 * @Date: 2025-04-09 17:39
 * @Description:
 */
public class Solution3375 {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            } else if (num > k) {
                set.add(num);
            }
        }
        return set.size();
    }
}
