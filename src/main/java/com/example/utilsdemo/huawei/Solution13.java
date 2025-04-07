package com.example.utilsdemo.huawei;

import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-05 16:37
 * @Description:
 */
public class Solution13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String box = scanner.next();
        int n = scanner.nextInt();

        StringBuilder[] poss = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            poss[i] = new StringBuilder();
        }

        int dir = 1;
        int count = 1;
        int index = 0;
        for (int i = 0; i < box.length(); i++) {
            char c = box.charAt(i);
            poss[index].append(c);
            if (count == n) {
                //重置
                count = 1;
                //转向
                dir = dir == 1 ? -1 : 1;
            } else {
                index += dir;
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(poss[i].toString());
        }
    }
}
