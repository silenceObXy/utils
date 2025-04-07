package com.example.utilsdemo.leetcode.test;

/**
 * @Author: xy
 * @Date: 2024-11-01 17:00
 * @Description:
 */
public class Solution134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] oil = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            oil[i] = gas[i] - cost[i];
            total += oil[i];
        }
        if (total < 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (oil[i] <= 0) {
                continue;
            }
            int useOil = 0;
            for (int j = 0; j < n; j++) {
                int index = (i+j) < n ? i+j : i+j -n;
                useOil += oil[index];
                if (useOil < 0) {
                    break;
                }
            }
            if (useOil >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {3,4,5,1,2};
        int i = canCompleteCircuit(a, b);
        System.out.println(i);
    }
}
