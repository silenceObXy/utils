package com.example.utilsdemo.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-06 09:14
 * @Description:
 */
public class Solution15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        ArrayList<Integer> maxValue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            ints[i] = v;
            int current = map.getOrDefault(v, 0) + 1;
            map.put(v, current);
            if (current > max) {
                max = current;
            }
        }

        int finalMax = max;
        map.forEach((k, v) -> {
            if (v == finalMax) {
                maxValue.add(k);
            }
        });

        int min = n;
        for (int i = 0; i < maxValue.size(); i++) {
            int left = 0;
            int right = n - 1;
            for (int j = 0; j < n; j++) {
                if (ints[j] == maxValue.get(i)) {
                    left = j;
                    break;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (ints[j] == maxValue.get(i)) {
                    right = j;
                    break;
                }
            }
            min = Math.min(min, right - left + 1);
        }
        System.out.println(min);
    }
}
