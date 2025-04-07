package com.example.utilsdemo.huawei;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xy
 * @Date: 2025-03-11 09:42
 * @Description:
 */
public class Solution27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        String str = scanner.nextLine();

        int len = num.length();
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = num.charAt(i) - '0';
        }

        String result = dealQuestion(ints, str);
        System.out.println(result);
    }

    private static String dealQuestion(int[] ints, String str) {
        return null;
    }
}
