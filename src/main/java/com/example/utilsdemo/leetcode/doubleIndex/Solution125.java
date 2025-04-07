package com.example.utilsdemo.leetcode.doubleIndex;

/**
 * @Author: xy
 * @Date: 2024-11-05 17:47
 * @Description:
 */
public class Solution125 {
    public static boolean isPalindrome(String s) {
        String target = s.toLowerCase();
        int n = target.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = target.charAt(i);
            if ((c >= 48 && c <= 57) || (c >= 97 && c <= 122)) {
                builder.append(c);
            }
        }
        int len = builder.length();
        for (int i = 0; i < len / 2; i++) {
            if (builder.charAt(i) != builder.charAt(len - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome("a`l;`` 1o1 ??;l`");
    }
}
