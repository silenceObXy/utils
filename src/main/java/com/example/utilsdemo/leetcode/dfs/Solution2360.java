package com.example.utilsdemo.leetcode.dfs;

/**
 * @Author: xy
 * @Date: 2025-03-31 16:57
 * @Description:
 */
public class Solution2360 {
    public static int longestCycle(int[] edges) {
        int n = edges.length;
        int max = -1;
        int[] map = new int[n];
        for (int target : edges) {
            //存储路径
            int[] list = new int[n];
            if (target == -1 || map[target] != 0) {
                continue;
            }
            list[target] = 1;
            max = Math.max(dfs(edges, target, list, map, 1), max);
        }
        return max;
    }

    private static int dfs(int[] edges, int target, int[] list, int[] map, int count) {
        int value = edges[target];
        //遇到死胡同
        if (value == -1) {
            //这条线路的点都置为死胡同
            fillMap(list, map, -1);
            return -1;
        }
        //先前走过的路
        if (map[value] != 0) {
            fillMap(list, map, map[value]);
            return map[value];
        }
        //遇到闭环
        if (list[value] > 0) {
            int len = count - list[value] + 1;
            fillMap(list, map, len);
            return len;
        }
        //添加路径
        list[value] = ++count;
        return dfs(edges, value, list, map, count);
    }

    private static void fillMap(int[] list, int[] map, int len) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != 0) {
                map[i] = len;
            }
        }
    }

    public int longestCycle2(int[] edges) {
        int n = edges.length;
        int[] label = new int[n];
        int current_label = 0, ans = -1;
        for (int i = 0; i < n; ++i) {
            if (label[i] != 0) {
                continue;
            }
            int pos = i, start_label = current_label;
            while (pos != -1) {
                ++current_label;
                // 如果遇到了已经遍历过的节点
                if (label[pos] != 0) {
                    // 如果该节点是这一次 i 循环中遍历的，说明找到了新的环，更新答案
                    if (label[pos] > start_label) {
                        ans = Math.max(ans, current_label - label[pos]);
                    }
                    break;
                }
                label[pos] = current_label;
                pos = edges[pos];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] ints = {2, 6, 4, 7, 6, 0, 8, -1, 4};
        System.out.println(longestCycle(ints));
    }
}
