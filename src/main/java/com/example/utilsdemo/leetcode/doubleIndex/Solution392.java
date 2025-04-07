package com.example.utilsdemo.leetcode.doubleIndex;

/**
 * @Author: xy
 * @Date: 2024-11-07 10:33
 * @Description:
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m > n) {
            return false;
        }
        int left = 0;
        int right = 0;
        while (left < m && right < n) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
                right++;
            } else {
                right++;
            }
        }
        return left == m;
    }
}
