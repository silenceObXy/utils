package com.example.utilsdemo.leetcode.str;

/**
 * @Author: xy
 * @Date: 2025-03-17 09:40
 * @Description:
 */
public class Solution1963 {
    public int minSwaps(String s) {
        int cnt = 0;
        int mincnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                cnt += 1;
            } else {
                cnt -= 1;
                mincnt = Math.min(mincnt, cnt);
            }
        }
        return (-mincnt + 1) / 2;
    }


}
