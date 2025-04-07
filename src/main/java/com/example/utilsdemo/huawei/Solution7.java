package com.example.utilsdemo.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-03 14:17
 * @Description:
 */
public class Solution7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (String v : scanner.nextLine().split(" ")) {
            list.add(Integer.parseInt(v));
        }

        int size = list.size();
        int[] dp = new int[size];
        int[] deduct = new int[size];
        int[] score = new int[size];

        //初始化
        score[0] = list.get(0);
        deduct[0] = 0;
        dp[0] = list.get(0);

        for (int i = 1; i < size; i++) {
            score[i] = score[i - 1] + list.get(i);
            if (score[i] >= 100) {
                break;
            }
            deduct[i] = deduct[i - 1] + score[i - 1];
            dp[i] = score[i] - deduct[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
