package com.example.utilsdemo.leetcode.binary;

/**
 * @Author: xy
 * @Date: 2025-02-27 11:22
 * @Description:
 */
public class Solution {
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int max = Math.max(lena, lenb) + 1;
        int[] ints = new int[max];
        for (int i = 0; i < max - 1; i++) {
            int v1 = lena <= i ? 0 : a.charAt(lena - i - 1) - 48;
            int v2 = lenb <= i ? 0 : b.charAt(lenb - i - 1) - 48;
            ints[i + 1] += (v1 + v2 + ints[i]) / 2;
            ints[i] = (v1 + v2 + ints[i]) % 2;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0 || i != ints.length - 1) {
                builder.append(ints[i]);
            }
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        String s = new Solution().addBinary("11", "1");
    }
}
