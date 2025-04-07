package com.example.utilsdemo.leetcode.pic;

import java.util.ArrayList;

/**
 * @Author: xy
 * @Date: 2025-02-17 11:00
 * @Description:
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        char[][] df = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (df[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    //深度优先
                    dfs2(grid, df, i, j);
                }
            }
        }
        return count;
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] df = new int[m][n];
        for (int i = 0; i < m; i++) {
            dfs(board, df, i, 0);
            dfs(board, df, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, df, 0, i);
            dfs(board, df, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && df[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] a = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        Solution s = new Solution();
        s.solve(a);
    }

    private void dfs(char[][] grid, int[][] df, int i, int j) {
        if (grid[i][j] == 'X') {
            return;
        }
        df[i][j] = 1;
        //方向
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int k = 0; k < dir.length; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 'O' && df[x][y] == 0) {
                dfs(grid, df, x, y);
            }
        }
    }

    private void dfs2(char[][] grid, char[][] df, int i, int j) {
        df[i][j] = 1;
        //方向
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int k = 0; k < dir.length; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && df[x][y] == 0) {
                dfs2(grid, df, x, y);
            }
        }
    }

}
