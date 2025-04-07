package com.example.utilsdemo.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: xy
 * @Date: 2024-10-16 16:49
 * @Description:
 */
public class Solution1218 {
    public static int longestSubsequence(int[] arr, int difference) {
        int length = arr.length;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
            max = Math.max(max, map.get(arr[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,4};
        int number = longestSubsequence(ints, 1);
        System.out.println(number);
    }
}
