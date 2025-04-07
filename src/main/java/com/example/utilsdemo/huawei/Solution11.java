package com.example.utilsdemo.huawei;

import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-03-04 15:29
 * @Description:
 */
public class Solution11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int num = turnOne(map, n, m);
        System.out.println(num);
    }

    private static int turnOne(int[][] map, int n, int m) {
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    count++;
                    bfs(map, i, j, dir);
                }
            }
        }
        return count;
    }

    private static void bfs(int[][] map, int i, int j, int[][] dir) {
        map[i][j] = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
                if (map[x][y] == 1) {
                    bfs(map, x, y, dir);
                }
            }
        }
    }
}
