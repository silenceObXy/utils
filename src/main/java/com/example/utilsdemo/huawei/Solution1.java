package com.example.utilsdemo.huawei;

import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-02-28 11:22
 * @Description:
 */
public class Solution1 {
    /**
     * 暴力算法
     *
     * @param args
     */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int total = scanner.nextInt();
//        int[] tree = new int[total];
//        int dieNums = scanner.nextInt();
//        int[] dieTree = new int[total];
//        for (int i = 0; i < dieNums; i++) {
//            int index = scanner.nextInt();
//            tree[index - 1] = 1;
//            dieTree[i] = index;
//        }
//        int addNum = scanner.nextInt();
//        if (addNum >= dieNums) {
//            System.out.println(total);
//        } else {
//            int max = 0;
//            for (int index : dieTree) {
//                int value = 0;
//                int newTrees = addNum;
//                for (int j = index; j < total; j++) {
//                    if (tree[j] == 0) {
//                        value++;
//                    } else if (tree[j] != 0 && newTrees == 0) {
//                        break;
//                    }else {
//                        value++;
//                        newTrees--;
//                    }
//                }
//                max = Math.max(value, max);
//            }
//            System.out.println(max);
//        }
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int[] tree = new int[total];
        int dieNums = scanner.nextInt();
        for (int i = 0; i < dieNums; i++) {
            int index = scanner.nextInt();
            tree[index - 1] = 1;
        }
        int addNum = scanner.nextInt();
        //去除特殊情况
        if (addNum >= dieNums) {
            System.out.println(total);
            return;
        }
        int result = getLenList(tree, addNum);
        System.out.println(result);
    }

    /**
     * 窗口滑动
     * @param tree
     * @param addNum
     * @return
     */
    private static int getLenList(int[] tree, int addNum) {
        int left = 0;
        int right = 0;
        int dieNum = tree[0] == 1 ? 1 : 0;
        int len = tree.length;
        int max = 0;
        while (right < len - 1) {
            if (dieNum <= addNum) {
                right++;
                dieNum += tree[right];
            } else {
                dieNum -= tree[left];
                left++;
            }
            if (dieNum <= addNum) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }

}
