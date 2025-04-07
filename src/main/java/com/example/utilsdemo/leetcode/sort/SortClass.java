package com.example.utilsdemo.leetcode.sort;

/**
 * @Author: xy
 * @Date: 2025-02-18 15:18
 * @Description:
 */
public class SortClass {
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // pi 是分区索引，array[pi] 已经排好序
            int pi = partition(array, left, right);

            // 递归地对分区进行排序
            quickSort(array, left, pi - 1);  // 左侧子数组
            quickSort(array, pi + 1, right); // 右侧子数组
        }
    }

    public void test() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
    }

    // 分区方法
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // 选择最后一个元素作为枢轴
        int i = (low - 1); // 较小元素的索引

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于枢轴
            if (array[j] <= pivot) {
                i++;

//                // 交换 array[i] 和 array[j]
//                int temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
            }
        }

        // 交换 array[i+1] 和 array[high] (或枢轴)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4, 7, 6};
//        bubbleSort(arr);
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
