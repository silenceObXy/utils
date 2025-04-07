package com.example.utilsdemo.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-07 17:14
 * @Description:
 */
public class Solution25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int n = scanner.nextInt();

        int[] bucket = new int[n];
        for (int i = 0; i < n; i++) {
            bucket[i] = scanner.nextInt();
        }

        int[] result = findBail(bucket, sum, n);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findBail(int[] bucket, int sum, int n) {
        int[] result = new int[n];

        int total = Arrays.stream(bucket).sum();
        if (total < sum) {
            return new int[]{};
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(bucket[i], max);
        }

        while (max > 0) {
            int count = total - sum;
            for (int j = 0; j < n; j++) {
                count -= Math.max(0, bucket[j] - max);
            }
            if (count <= 0) {
                break;
            }
            max--;
        }

        for (int i = 0; i < n; i++) {
            result[i] = Math.max(0, bucket[i] - max);
        }
        return result;
    }
}
