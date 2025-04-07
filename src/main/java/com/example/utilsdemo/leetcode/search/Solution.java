package com.example.utilsdemo.leetcode.search;

/**
 * @Author: xy
 * @Date: 2025-02-26 17:23
 * @Description: 二分法查找
 */
public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int index = 0;
        while (left <= right) {
            index = (left + right) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return left;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int index = (left + right) / 2;
            int x = index / n;
            int y = index % n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}
