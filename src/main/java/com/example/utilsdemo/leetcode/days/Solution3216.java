package com.example.utilsdemo.leetcode.days;

/**
 * @Author: xy
 * @Date: 2024-10-30 15:21
 * @Description:
 */
public class Solution3216 {
    public String getSmallestString(String s) {
        int n = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            char first = s.charAt(i);
            char next = s.charAt(i + 1);
            if ((first - next) % 2 == 0 && first > next) {
                for (int j = 0; j < n; j++) {
                    char target = s.charAt(i);
                    if (i == j) {
                        builder.append(s.charAt(j + 1));
                    } else if (i == j - 1) {
                        builder.append(target);
                    } else {
                        builder.append(s.charAt(j));
                    }
                }
                return builder.toString();
            }
        }
        return s;
    }
}
