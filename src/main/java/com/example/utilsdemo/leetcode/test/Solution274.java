package com.example.utilsdemo.leetcode.test;

import java.util.Arrays;

/**
 * @Author: xy
 * @Date: 2024-10-30 15:55
 * @Description:
 */
public class Solution274 {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (n - i <= citations[i]) {
                return n-i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = hIndex(new int[]{3,0,6,1,5});
    }
}
