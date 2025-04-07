package com.example.utilsdemo.leetcode.str;

import java.util.HashSet;

/**
 * @Author: xy
 * @Date: 2025-03-28 09:45
 * @Description:
 */
public class Solution2716 {
    public int minimizedStringLength(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                count++;
                set.add(c);
            }
        }
        return count;
    }
}
