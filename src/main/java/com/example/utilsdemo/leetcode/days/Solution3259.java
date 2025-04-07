package com.example.utilsdemo.leetcode.days;

/**
 * @Author: xy
 * @Date: 2024-11-01 14:01
 * @Description:
 */
public class Solution3259 {
    public static long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] dp = new long[n][2];
        //dp[i][0]表示在A中取值，dp[i][1]表示在B中取值
        dp[0][0] = energyDrinkA[0];
        dp[0][1] = energyDrinkB[0];
        dp[1][0] = energyDrinkA[0] + energyDrinkA[1];
        dp[1][1] = energyDrinkB[0] + energyDrinkB[1];
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1]) + energyDrinkA[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0]) + energyDrinkB[i];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] a = {5, 5, 6, 3, 4, 3, 3, 4};
        int[] b = {5, 3, 3, 4, 4, 6, 6, 3};
        long l = maxEnergyBoost(a, b);
        System.out.println(l);
    }
}
