package com.example.utilsdemo.leetcode.str;

/**
 * @Author: xy
 * @Date: 2025-03-31 09:26
 * @Description:
 */
public class Solution2278 {
    public int percentageLetter(String s, char letter) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (letter == s.charAt(i)) {
                count++;
            }
        }
        int result = count * 100 / n;
        return result;
    }
}
