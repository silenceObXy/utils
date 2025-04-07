package com.example.utilsdemo.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-06 14:20
 * @Description:
 */
public class Solution19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        int k = scanner.nextInt();

        int result = isCover(s1, s2, k);
        System.out.println(result);
    }

    private static int isCover(String s1, String s2, int k) {
        int n1 = s1.length();
        int n2 = s2.length();
        int total = k + n1;

        if (total > n2) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        //1、初始化
        for (int i = 0; i < n1; i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < total; i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        if (checkStatus(map)) {
            return 0;
        }
        for (int i = total; i < n2; i++) {
            char c1 = s1.charAt(i);
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) - 1);
            }
            char c2 = s1.charAt(i - total);
            if (map.containsKey(c2)) {
                map.put(c2, map.get(c2) + 1);
            }
            if (checkStatus(map)) {
                return 0;
            }
        }
        return -1;
    }

    private static boolean checkStatus(HashMap<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }
}
