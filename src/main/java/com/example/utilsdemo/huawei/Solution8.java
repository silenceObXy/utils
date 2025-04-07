package com.example.utilsdemo.huawei;

import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-03 14:43
 * @Description:
 */
public class Solution8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();

        int length = text.length();
        int avg = length / 4;

        int[] dirNum = new int[4];
        for (int i = 0; i < length; i++) {
            int di = findDirection(text.charAt(i));
            dirNum[di]++;
        }

        int diff = 0;

        for (int i = 0; i < 4; i++) {
            dirNum[i] -= avg;
            dirNum[i] = Math.max(dirNum[i], 0);
            diff += dirNum[i];
        }

        if (diff == 0) {
            System.out.println(0);
            return;
        }

        //滑动窗口
        int left = 0;
        int right = 0;
        int min = length;

        while (right < length) {
            dirNum[findDirection(text.charAt(right))]--;
            while (isBalance(dirNum)) {
                min = Math.min(min, right - left + 1);
                dirNum[findDirection(text.charAt(left))]++;
                left++;
            }
            right++;
        }
        System.out.println(min);

    }

    private static boolean isBalance(int[] dirNum) {
        for (int i = 0; i < dirNum.length; i++) {
            if (dirNum[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private static int findDirection(char v) {
        if ('W' == v) {
            return 0;
        } else if ('S' == v) {
            return 1;
        } else if ('A' == v) {
            return 2;
        } else {
            return 3;
        }
    }
}
