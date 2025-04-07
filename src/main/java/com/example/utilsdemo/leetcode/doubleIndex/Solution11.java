package com.example.utilsdemo.leetcode.doubleIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xy
 * @Date: 2024-11-08 10:49
 * @Description:
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left + 1));
            if (height[left] >= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    //15、三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = 1;
        while (mid < right) {
            int sum = nums[right] + nums[left] + nums[mid];
            if (sum == 0) {
                List<Integer> ints = Arrays.asList(nums[left], nums[mid], nums[right]);
                ans.add(ints);
                right--;
            } else if (sum > 0) {
                right--;
            } else {
                for (int i = left + 1; i < right - 1; i++) {
                    sum = nums[right] + nums[left] + nums[i];
                    if (sum == 0) {
                        mid = i;
                        List<Integer> ints = Arrays.asList(nums[left], nums[mid], nums[right]);
                        ans.add(ints);
                    }
                }
                left++;
                mid++;
            }
        }
        List<List<Integer>> collect = ans.stream().distinct().collect(Collectors.toList());
        return collect;
    }

}
