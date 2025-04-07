package com.example.utilsdemo.leetcode.days;

/**
 * @Author: xy
 * @Date: 2024-08-30 14:09
 * @Description:
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        //超时
//        int max = 0;
//        int n = prices.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int income = prices[j] - prices[i];
//                max = Math.max(max, income);
//            }
//        }
//        return max;

        int buy = prices[0];
        int sale = prices[0];
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else {
                sale = Math.max(sale, prices[i] - buy);
            }
        }
        return sale;
    }
}
