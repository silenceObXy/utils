package com.example.utilsdemo.huawei;

import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-06 11:21
 * @Description:
 */
public class Solution18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int days = scanner.nextInt();
        int[] goodsNum = new int[n];
        for (int i = 0; i < n; i++) {
            goodsNum[i] = scanner.nextInt();
        }

        int[][] goods = new int[n][days];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < days; j++) {
                goods[i][j] = scanner.nextInt();
            }
        }

        int salary = getMaxSalary(goods, goodsNum, n, days);
        System.out.println(salary);
    }

    private static int getMaxSalary(int[][] goods, int[] goodsNum, int n, int days) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            int[][] dp = new int[days][2];
            dp[0][0] = 0;
            dp[0][1] -= goods[i][0];
            for (int j = 1; j <days; j++) {
                //当天的价格
                int reword = goods[i][j];
                //不持有
                dp[j][0] = Math.max(dp[j - 1][1] + reword, dp[j - 1][0]);
                //持有
                dp[j][1] = Math.max(dp[j - 1][1] + goods[i][j-1] - reword, dp[j - 1][1]);
            }
            int max = 0;
            for (int j = 0; j < days; j++) {
                max = Math.max(max, Math.max(dp[j][0], dp[j][1]));
            }
            total += max*goodsNum[i];
        }
        return total;
    }
}
