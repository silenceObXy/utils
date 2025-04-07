package com.example.utilsdemo.leetcode.days;

import cn.hutool.core.collection.CollectionUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @Author: xy
 * @Date: 2024-08-29 15:55
 * @Description:
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int count = 1;
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > length/2) {
                return nums[i];
            }
        }
        return 0;
    }
}
