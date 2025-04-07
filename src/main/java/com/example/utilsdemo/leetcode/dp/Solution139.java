package com.example.utilsdemo.leetcode.dp;

import java.util.List;

/**
 * @Author: xy
 * @Date: 2024-09-14 17:03
 * @Description:
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (i != 0 && !dp[i - 1] ) {
                continue;
            }
            for (int j = i; j < len; j++) {
                String target = s.substring(i, j + 1);
                if (wordDict.contains(target)) {
                    dp[j] = true;
                    if (j == len - 1) {
                        return true;
                    }
                }
            }
        }
        return dp[len - 1];
    }
}
