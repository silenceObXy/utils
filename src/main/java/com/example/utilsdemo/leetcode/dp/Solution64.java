package com.example.utilsdemo.leetcode.dp;

/**
 * @Author: xy
 * @Date: 2024-09-03 14:10
 * @Description:
 */
public class Solution64 {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] dp = {{1,2,3},{4,5,6}};
        minPathSum(dp);
    }
}
