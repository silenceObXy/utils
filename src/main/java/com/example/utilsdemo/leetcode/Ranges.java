package com.example.utilsdemo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xy
 * @Date: 2024-11-20 11:53
 * @Description:
 */
public class Ranges {
    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        int n = nums.length;
        int left = 0;
        int right = 1;
        if (n == 1) {
            list.add(nums[0] + "");
            return list;
        }
        while (left < n && right < n) {
            if (nums[right - 1] + 1 != nums[right]) {
                if (left == right - 1) {
                    list.add(nums[left] + "");
                } else {
                    list.add(nums[left] + "->" + nums[right - 1]);
                }
                left = right;
                if (right == n - 1) {
                    list.add(nums[left] + "");
                }
            } else if (right == n - 1) {
                list.add(nums[left] + "->" + nums[right]);
            }
            right++;
        }
        return list;
    }

//    public int[][] merge(int[][] intervals) {
//        int n = intervals.length;
//        ArrayList<int[][]> list = new ArrayList<>();
//        int left = intervals[0][0];
//        for (int i = 1; i < n; i++) {
//            if (intervals[i][0] > intervals)
//        }
//    }

    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(ints));
    }
}
