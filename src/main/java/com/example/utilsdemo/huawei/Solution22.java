package com.example.utilsdemo.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-07 10:35
 * @Description:
 */
public class Solution22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split(" ");
        int len = text.length;

        Arrays.sort(text);
        String maxValue = "";

        for (int i = 0; i < len; i++) {
            String temp = text[i];
            for (int j = 0; j < len; j++) {
                if (i != j && text[j].equals(temp.substring(0, temp.length() - 1)) &&
                        maxValue.length() <= temp.length()) {
                    maxValue = temp;
                    break;
                }
            }
        }

        System.out.println(maxValue);
    }
}
