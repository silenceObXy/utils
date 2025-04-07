package com.example.utilsdemo.leetcode.str;

/**
 * @Author: xy
 * @Date: 2025-03-31 09:30
 * @Description:
 */
public class Solution2109 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder builder = new StringBuilder();
        int n = s.length();
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (index < spaces.length && spaces[index] == i) {
                builder.append(" ");
                index++;
            }
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
