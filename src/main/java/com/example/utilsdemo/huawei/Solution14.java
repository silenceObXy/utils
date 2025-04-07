package com.example.utilsdemo.huawei;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-05 16:59
 * @Description:
 */
public class Solution14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int length = split.length;
        int[] list = new int[length];

        for (int i = 0; i < length; i++) {
            list[i] = Integer.parseInt(split[i]);
        }

        int left = -127;
        int right = 128;

        int bestK = 0;
        BigDecimal bestDiff = BigDecimal.valueOf(Double.MAX_VALUE);

//        while (left < right) {
//            int mid = (left + right) / 2;
//            BigDecimal avg = getAvg(list, mid);
//            double diff = Math.abs((double)avg.subtract(BigDecimal.valueOf(128)));
//            if (diff < bestDiff || (diff == bestDiff && mid < bestK)) {
//                bestDiff = diff;
//                bestK = mid;
//            }
//
//            if (avg.compareTo(BigDecimal.valueOf(128)) > 0) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }

        System.out.println(bestK);
    }

    private static BigDecimal getAvg(int[] list, int mid) {
        int total = 0;
        for (int j : list) {
            int v = j + mid;
            int temp = Math.max(0, Math.min(v, 255));
            total += temp;
        }
        return BigDecimal.valueOf(total).divide(BigDecimal.valueOf(list.length));
    }
}
