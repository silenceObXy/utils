package com.example.utilsdemo.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xy
 * @Date: 2024-10-18 09:42
 * @Description:
 */
public class Solution1027 {
    public int longestArithSeqLength(int[] nums) {
        int length = nums.length;
        int minValue = Arrays.stream(nums).min().getAsInt();
        int maxValue = Arrays.stream(nums).max().getAsInt();
        //最大差值
        int maxDiff = maxValue - minValue;
        int[][] dp = new int[length][2*maxDiff + 1];
        int max = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + maxDiff;
                dp[i][diff] = Math.max(dp[j][diff] + 1, dp[i][diff]);
                max = Math.max(max, dp[i][diff]);
            }
        }
        return max + 1;
    }


    public int longestArithSeqLength2(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer>[] map = new HashMap[length];
        Arrays.setAll(map, it -> new HashMap<>());
        int max = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                map[i].put(diff, map[j].getOrDefault(diff, 0) + 1);
                max = Math.max(max, map[i].get(diff));
            }
        }
        return max + 1;
    }
}
