package com.example.utilsdemo.leetcode.days;

/**
 * @Author: xy
 * @Date: 2024-08-28 14:31
 * @Description:
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int num = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (val != nums[i]) {
                nums[num] = nums[i];
                num++;
            }
        }
        return num;
    }
}
