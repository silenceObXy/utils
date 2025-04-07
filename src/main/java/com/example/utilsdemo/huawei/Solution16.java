package com.example.utilsdemo.huawei;

import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-06 09:55
 * @Description:
 */
public class Solution16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();

        int len = a.length();
        int[] ints = new int[len];

        int indexA = 0;
        int indexB = 0;
        int count = 0;
        while (indexA < len) {
            if (a.charAt(indexA) == b.charAt(indexB) && ints[indexA] == 0) {
                ints[indexA] = 1;
                indexA++;
                indexB++;
            } else {
                indexA++;
            }

            if (indexB == b.length()) {
                count++;
                indexA = 0;
                indexB = 0;
            }
        }
        System.out.println(count);
    }
}
