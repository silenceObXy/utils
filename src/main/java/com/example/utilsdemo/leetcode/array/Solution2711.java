package com.example.utilsdemo.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xy
 * @Date: 2025-03-25 16:39
 * @Description:
 */
public class Solution2711 {
    public static int[][] differenceOfDistinctValues2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] map = new int[m][n];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    int f = i;
                    int b = j;
                    while (f < m && b < n) {
                        set.add(grid[f][b]);
                        map[f][b] = set.size();
                        f++;
                        b++;
                    }
                    set.clear();
                }
            }
        }

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    int f = i;
                    int b = j;
                    while (f < m && b < n) {
                        result[f][b] = Math.abs(map[m - 1 - f][n - 1 - b] - map[f][b]);
                        if ((f == 0 || b == 0 || f == n - 1 || b == m - 1) && result[f][b] == 0) {
                            result[f][b] = 1;
                        }
                        f++;
                        b++;
                    }
                }
            }
        }
        return result;
    }

    public static int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Set<Integer> s1 = new HashSet<>();
                int x = i + 1, y = j + 1;
                while (x < m && y < n) {
                    s1.add(grid[x][y]);
                    x += 1;
                    y += 1;
                }
                Set<Integer> s2 = new HashSet<>();
                x = i - 1; y = j - 1;
                while (x >= 0 && y >= 0) {
                    s2.add(grid[x][y]);
                    x -= 1;
                    y -= 1;
                }
                res[i][j] = Math.abs(s1.size() - s2.size());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = {{1,2,3}, {3,1,5}, {3,2,1}};
        differenceOfDistinctValues(ints);
    }
}
