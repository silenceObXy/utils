package com.example.utilsdemo.leetcode.str;

/**
 * @Author: xy
 * @Date: 2025-04-10 17:35
 * @Description:
 */
public class Solution2999 {
    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        int num = Integer.parseInt(s);
        if (finish < num) {
            return 0;
        }
        long n = (long) Math.pow(10, s.length());
        n = n == 0 ? 1 : n;
        long l = num >= start ? -1 : start / n  - (start % n >= num ? 0 : 1);
        long r = finish / n - (finish % n >= num ? 0 : 1);
        if (l > limit) {
            return 0;
        }
        return Math.min(limit, r) - l;
    }

    public static void main(String[] args) {
        System.out.println(numberOfPowerfulInt(15, 215, 6, "10"));
    }
}
