package com.example.utilsdemo.leetcode.days;

import java.util.HashMap;

/**
 * @Author: xy
 * @Date: 2024-08-29 11:42
 * @Description:
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int slow = 2;
        int fast = 2;
        while (fast < length) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
