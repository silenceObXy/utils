package com.example.utilsdemo.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-04 14:23
 * @Description:
 */
public class Solution10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();;
        }

        int left = 0;
        int right = n - 1;
        Arrays.sort(ints);
        while (right - left >= k) {
            int lInt = Math.abs(ints[left] - x);
            int rInt = Math.abs(ints[right] - x);
            if (lInt > rInt) {
                left++;
            } else {
                right--;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = left; i <= right; i++) {
            stringBuilder.append(ints[i]).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
