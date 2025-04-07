package com.example.utilsdemo.leetcode.dp;

import java.util.Arrays;

/**
 * @Author: xy
 * @Date: 2024-10-25 14:28
 * @Description:
 */
public class Solution96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //j表示分到左边的个数
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        Arrays.sort(rewardValues);
        int maxNum = rewardValues[n-1];
        int[] dp = new int[maxNum * 2];
        dp[0] = 1;
        for (int v : rewardValues) {
            for (int i = 2*v-1; i >= v; i--) {
                //此时i可满足的最大累加值
                //轮训寻找小于v的累加值
                if (dp[i-v] == 1) {
                    //该值可以得到
                    dp[i] = 1;
                }
            }
        }
        for (int i = maxNum*2-1; i > 0; i--) {
            if (dp[i] == 1) {
                return i;
            }
        }
        return 0;
    }

    public static int maxTotalReward3(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int m = rewardValues[rewardValues.length - 1];
        int[] dp = new int[2 * m];
        dp[0] = 1;
        for (int x : rewardValues) {
            for (int k = 2 * x - 1; k >= x; k--) {
                if (dp[k - x] == 1) {
                    dp[k] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) {
                res = i;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 6};
        int i = maxTotalReward3(ints);
        System.out.println(i);
    }
}
