package com.example.utilsdemo.huawei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-07 14:07
 * @Description:
 */
public class Solution24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int step = minSteps(m, n, x);
        System.out.println(step);
    }

    private static int minSteps(int m, int n, int x) {
        ArrayList<Integer> list = new ArrayList<>();

        search(m, n, x, 0, 0, 0, list);
        return list.isEmpty() ? 0: Collections.min(list);
    }

    private static void search(int m, int n, int x, int opp_s, int opp_w, int count, ArrayList<Integer> list) {
        if (m == 0 && n == 0) {
            list.add(count);
            return;
        }
        if (m + n < x) {
            list.add(count + 1);
            return;
        }

        for (int i = 0; i <= Math.min(m, x); i++) {
            for (int j = 0; j <= Math.min(n, x); j++) {
                if (i + j == 0 || i + j > x) {
                    continue;
                }

                if (m - i < n - j) {
                    continue;
                }
                if (opp_s + i < opp_w + i) {
                    continue;
                }

                search(m - i, n - j, x, opp_s + i, opp_w + j, count+1, list);
            }
        }
    }
}
