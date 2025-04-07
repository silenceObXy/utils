package com.example.utilsdemo.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-06 10:34
 * @Description:
 */
public class Solution17 {
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();

        String[] box = scanner.nextLine().split(" ");

        int id = -1;

        int len = box.length;
        for (int i = 0; i < len; i++) {
            String value = box[i];
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < value.length(); j++) {
                char c = value.charAt(j);
                char newV = Character.toLowerCase(c);
                if (newV > 'a' && newV < 'z') {
                    builder.append(newV);
                }
            }
            String s = builder.toString();
            Arrays.sort(s.split(""));
            box[i] = s;
        }

        for (int i = 0; i < len; i++) {
            if (key.equals(box[i])) {
                id = i + 1;
                break;
            }
        }
        System.out.println(id);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取输入，预处理 referenceKey
        String referenceKey = sanitizeAndSort(scanner.nextLine());
        // 读取 containers 列表，按空格分隔
        String[] containers = scanner.nextLine().split(" ");
        // 查找匹配索引
        int matchingIndex = findMatchIndex(referenceKey, containers);
        // 输出匹配结果
        System.out.println(matchingIndex);
    }
    /**
     * 预处理字符串：过滤非字母字符，转为小写，并排序
     *
     * @param input 原始字符串
     * @return 经过排序和过滤后的字符串
     */
    private static String sanitizeAndSort(String input) {
        // 去除非字母字符，转小写，转为字符数组
        char[] filteredChars = input.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
        // 对字符数组排序
        Arrays.sort(filteredChars);
        // 转为字符串返回
        return new String(filteredChars);
    }
    /**
     * 在 containers 中查找第一个匹配 referenceKey 的索引
     *
     * @param referenceKey 预处理后的参考字符串
     * @param containers 容器字符串数组
     * @return 第一个匹配的容器索引（从 1 开始），未找到返回 -1
     */
    private static int findMatchIndex(String referenceKey, String[] containers) {
        for (int i = 0; i < containers.length; i++) {
            // 预处理当前容器
            String sortedBox = sanitizeAndSort(containers[i]);
            // 比较参考字符串与当前容器是否匹配
            if (referenceKey.equals(sortedBox)) {
                return i + 1; // 返回 1 基索引
            }
        }
        return -1; // 没有找到匹配，返回 -1
    }
}
