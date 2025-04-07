package com.example.utilsdemo.leetcode.days;

/**
 * @Author: xy
 * @Date: 2024-11-04 09:39
 * @Description:
 */
public class Solution633 {
    public static boolean judgeSquareSum(int c) {
        long sqrt = (long) Math.sqrt(c);
        long left = 0;
        long right = sqrt;
        while (right >= left) {
            long pow1 = left * left;
            long pow2 = right * right;
            if (pow1 + pow2 == c) {
                return true;
            } else if (pow1 + pow2 > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = judgeSquareSum(2147483600);
        System.out.println(b);
    }
}
