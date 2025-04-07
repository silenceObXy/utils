package com.example.utilsdemo.huawei;

import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-10 16:14
 * @Description:
 */
public class Solution26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] cmd = new String[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            cmd[i] = scanner.nextLine();
        }

        int result = calculateSort(cmd);
        System.out.println(result);
    }

    private static int calculateSort(String[] cmd) {
        int queueSize = 0;      // 当前队列的大小
        boolean sorted = true; // 标记队列是否处于有序状态
        int adjustments = 0;    // 记录排序操作的次数
        int i = 0;

        while (i < cmd.length) {
            if (cmd[i].startsWith("head")) {
                if (queueSize > 0 && sorted) {
                    sorted = false;
                }
                queueSize++;
            } else if (cmd[i].startsWith("tail")) {
                queueSize++;
            } else {
                if (queueSize == 0) {
                    i++;
                    continue;
                }
                if (!sorted) {
                    adjustments++;
                    sorted = true;
                }
                queueSize--;
            }
            i++;
        }

        return adjustments;
    }
}
