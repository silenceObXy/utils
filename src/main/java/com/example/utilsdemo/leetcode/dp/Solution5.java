package com.example.utilsdemo.leetcode.dp;

/**
 * @Author: xy
 * @Date: 2024-09-11 15:23
 * @Description:
 */
public class Solution5 {
    /**
     * 中心扩散
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1 || len == 0) {
            return s;
        }
        String longest = "";
        for (int i = 0; i < len; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                longest = longest.length() > (i - left) ? longest : s.substring(left, i + 1);
                left--;
            }
            while (right < len && s.charAt(i) == s.charAt(right)) {
                longest = longest.length() > (right - (left + 1)) ? longest : s.substring(left + 1, right + 1);
                right++;
            }
            while (left >= 0 && right < len && s.charAt(right) == s.charAt(left)) {
                longest = longest.length() > (right - left) ? longest : s.substring(left, right + 1);
                left--;
                right++;
            }
        }
        if ("".equals(longest)) {
            longest = String.valueOf(s.charAt(0));
        }
        return longest;
    }


    /**
     * 动态规划
     * @param s
     * @return
     */
    public static String dp(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[len][len];

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j-1][i-1])) {
                    dp[j][i] = true;
                    int l = i - j + 1;
                    if (l > maxLen) {
                        maxStart= j;
                        maxEnd = i;
                        maxLen = l;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd+1);
    }

    public static void main(String[] args) {
        String s = "ccc";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
