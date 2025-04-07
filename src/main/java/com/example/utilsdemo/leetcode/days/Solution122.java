package com.example.utilsdemo.leetcode.days;

/**
 * @Author: xy
 * @Date: 2024-09-02 11:02
 * @Description:
 */
public class Solution122 {
    /**
     * 动态规划，算出股票何时买卖最划算
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        //最大利润
        int max = 0;
        int buy = 0;
        for (int i = 1; i < length - 1; i++) {
            if (prices[i] > prices[i - 1] && prices[i] > prices[i + 1]) {
                max = max + prices[i] - prices[buy];
                buy = i + 1;
            } else if (prices[i] < prices[i - 1]){
                buy = i;
            }
        }
        if (prices[length - 1] > prices[buy]) {
            max = max + prices[length - 1] - prices[buy];
        }
        return max;
    }
}
