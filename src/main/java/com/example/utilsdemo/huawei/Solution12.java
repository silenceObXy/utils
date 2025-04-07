package com.example.utilsdemo.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-04 16:58
 * @Description:
 */
public class Solution12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalTime = scanner.nextInt();
        int n = scanner.nextInt();

        int[] times = new int[n];
        int[] rewords = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = scanner.nextInt();
            rewords[i] = scanner.nextInt();
        }

        int salary = getMaxSalary(n, totalTime, times, rewords);
        System.out.println(salary);
    }

    private static int getMaxSalary(int n, int t, int[] times, int[] rewords) {
        int[] dp = new int[t + 1];
        for (int i = 0; i < n; i++) {
            int time = times[i];
            int reword = rewords[i];

            for (int j = t; j >= time ; j--) {
                dp[j] = Math.max(dp[j], dp[j - time] + reword);
            }
        }

        return dp[t];
    }




//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            // 输入时间限制 T 和任务数 n
//            int T = sc.nextInt();
//            int n = sc.nextInt();
//
//            // 初始化任务耗时和奖励数组
//            int[] times = new int[n];
//            int[] rewards = new int[n];
//
//            // 输入每个任务的耗时和奖励
//            for (int i = 0; i < n; i++) {
//                times[i] = sc.nextInt();
//                rewards[i] = sc.nextInt();
//            }
//
//            // 输出最大奖励
//            System.out.println(maxReward(T, n, times, rewards));
//        }
//
//        // 计算最大奖励的函数
//        public static int maxReward(int T, int n, int[] times, int[] rewards) {
//            // 初始化 DP 数组，dp[j] 表示时间限制为 j 时的最大奖励
//            int[] dp = new int[T + 1];
//
//            // 遍历每个任务
//            for (int i = 0; i < n; i++) {
//                int time = times[i];   // 当前任务的耗时
//                int reward = rewards[i]; // 当前任务的奖励
//
//                // 倒序遍历时间限制，确保每个任务只被选择一次
//                for (int j = T; j >= time; j--) {
//                    // 更新时间限制 j 内的最大奖励
//                    dp[j] = Math.max(dp[j], dp[j - time] + reward);
//                }
//            }
//
//            // 返回时间限制为 T 时的最大奖励
//            return dp[T];
//        }

}
