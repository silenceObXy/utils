package com.example.utilsdemo.huawei;

import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-07 09:26
 * @Description:
 */
public class Solution21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int[][] trace = new int[m][n];

        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (trace[i][j] == 0) {
                    int v = dfs(i, j, dir, trace, map);
                    max = Math.max(v + 1, max);
                }
            }
        }
        System.out.println(max);
    }

    private static int dfs(int m, int n, int[][] dir, int[][] trace, int[][] map) {
        int count = 0;
        int temp = map[m][n];
        trace[m][n] = 1;
        for (int i = 0; i < 4; i++) {
            int x = m + dir[i][0];
            int y = n + dir[i][1];
            if (x >= 0 && x < map.length && y >= 0 && y < map[0].length
                    && trace[x][y] == 0 && Math.abs(map[x][y] - temp) <= 1) {
                count++;
                count += dfs(x, y, dir, trace, map);
            }
        }
        return count;
    }
}
