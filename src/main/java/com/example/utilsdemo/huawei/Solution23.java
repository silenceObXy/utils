package com.example.utilsdemo.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-07 11:56
 * @Description:
 */
public class Solution23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = scanner.nextInt();

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }

        Arrays.sort(ints);
        int min = ints[0];
        int max = ints[n - 1];
        int mid = 0;
        while (min < max) {
            mid = (min + max) / 2;
            if (meetConditions(ints, mid, num)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        System.out.println(mid);
    }

    private static boolean meetConditions(int[] ints, int mid, int num) {
        int length = ints.length;
        for (int i = 0; i < length; i++) {
            int anInt = ints[i];
            if (anInt >= mid) {
                continue;
            }
            num -= mid - anInt;
            if (num < 0) {
                return false;
            }

        }
        return true;
    }
}
