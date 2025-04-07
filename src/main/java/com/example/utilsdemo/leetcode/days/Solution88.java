package com.example.utilsdemo.leetcode.days;

import java.util.Arrays;

/**
 * @Author: xy
 * @Date: 2024-06-25 17:18
 * @Description:
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] numSort = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                numSort[p1 + p2] = nums2[p2++];
            } else if (p2 == n) {
                numSort[p1 + p2] = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                numSort[p1 + p2] = nums1[p1++];
            } else {
                numSort[p1 + p2] = nums2[p2++];
            }
        }
        for (int i = 0; i < m+n; i++) {
            nums1[i] = numSort[i];
        }
    }
}
