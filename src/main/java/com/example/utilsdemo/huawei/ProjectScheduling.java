package com.example.utilsdemo.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-03 17:47
 * @Description:
 */
public class ProjectScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int length = split.length;
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        int num = scanner.nextInt();

        Arrays.sort(ints);
        int temp = 0;
        for (int i = 0; i < length / 2; i++) {
            temp = ints[i];
            ints[i] = ints[length - i - 1];
            ints[length - i - 1] = temp;
        }

        int day = findMin(ints, num);
        System.out.println(day);
    }

    private static int findMin(int[] task, int n) {
        int left = task[0];
        int right = Arrays.stream(task).sum();


        while (left < right) {
            int[] works = new int[n];
            int mid = (left + right) / 2;
            if (backCall(task, works, 0, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean backCall(int[] task, int[] works, int index, int limit) {
        if (index >= task.length) {
            return true;
        }
        int value = task[index];
        for (int i = 0; i < works.length; i++) {
            if (works[i] + value <= limit) {
                works[i] += value;
                if (backCall(task, works, index + 1, limit)) {
                    return true;
                } else {
                    works[i] -= value;
                }
            }
        }
        return false;
    }
}
