package com.example.utilsdemo.leetcode.days;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: xy
 * @Date: 2024-08-28 15:44
 * @Description:
 */
public class Solution26 {
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                nums[left] = nums[i];
                left++;
                set.add(nums[i]);
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        removeDuplicates(nums);
    }
}
