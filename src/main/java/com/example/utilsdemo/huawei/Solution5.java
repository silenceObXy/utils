package com.example.utilsdemo.huawei;

import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-03 09:07
 * @Description:
 */
public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startAdd = scanner.nextInt();
        int num = scanner.nextInt();
        int[][] ints = new int[num][3];

        for (int i = 0; i < num; i++) {
            int start = scanner.nextInt();
            int value = scanner.nextInt();
            int end = scanner.nextInt();
            ints[i] = new int[]{start, value, end};
        }

        int target = num / 2 + 1;
        while (true) {
            for (int i = 0; i < num; i++) {
                if (ints[i][0] == startAdd) {
                    startAdd = ints[i][2];
                    target--;
                    if (target == 0) {
                        System.out.println(ints[i][1]);
                        return;
                    }
                }
            }
        }
    }
}
