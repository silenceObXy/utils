package com.example.utilsdemo.leetcode.array;

/**
 * @Author: xy
 * @Date: 2025-03-14 16:12
 * @Description:
 */
public class Solution3340 {
    public boolean isBalanced(String num) {
        int len = num.length();
        if (len < 2) {
            return false;
        }
        int odd = 0;
        int even = 0;

        for (int i = 0; i < len; i++) {
            int v = num.charAt(i) - '0';
            if (i % 2 == 1) {
                odd += v;
            } else {
                even += v;
            }
        }
        return odd == even;
    }
}
