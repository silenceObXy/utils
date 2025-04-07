package com.example.utilsdemo.leetcode.str;

/**
 * @Author: xy
 * @Date: 2025-03-27 09:31
 * @Description:
 */
public class Solution2712 {
    public static long minimumCost(String s) {
        int n = s.length();
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = s.charAt(i) - '0';
        }
        int mid = (n - 1) / 2;
        int target = map[mid];
        long score = 0;
        int lNum = 0;
        int rNum = 0;
        for (int i = mid - 1; i >= 0; i--) {
            if (Math.abs(map[i] - lNum) == target) {
                continue;
            }
            score += i +1;
            lNum = Math.abs(lNum - 1);
        }
        for (int i = mid + 1; i < n; i++) {
            if (Math.abs(map[i] - rNum) == target) {
                continue;
            }
            score += n - i;
            rNum = Math.abs(rNum - 1);
        }
        return score;
    }

    private static void reverce(int[] map, int left, int right) {
        for (int i = left; i <= right; i++) {
            map[i] = Math.abs(map[i] - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(minimumCost("000000100"));
    }
}
