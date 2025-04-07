package com.example.utilsdemo.huawei;

import java.util.*;

/**
 * @Author: xy
 * @Date: 2025-02-28 16:46
 * @Description:
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int[] startTime = new int[total];
        Arrays.fill(startTime, -1);
        int fireNum = scanner.nextInt();

        for (int i = 0; i < fireNum; i++) {
            int time = scanner.nextInt();
            int id = scanner.nextInt();
            startTime[id] = time;
        }

        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                if (startTime[j] == i) {//开始影响周边
                    //找到左右相连的发动机id
                    int leftId = (j - 1 + total) % total;
                    int rightId = (j + 1) % total;

                    if (startTime[leftId] == -1) {//启动
                        startTime[leftId] = i + 1;
                    }
                    if (startTime[rightId] == -1) {//启动
                        startTime[rightId] = i + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < total; i++) {
            max = Math.max(max, startTime[i]);
        }
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            if (startTime[i] == max) {
                list.add(i);
                count++;
            }
        }
        System.out.println(count);
        for (int val : list) {
            System.out.print(val + " ");
        }
    }

}
