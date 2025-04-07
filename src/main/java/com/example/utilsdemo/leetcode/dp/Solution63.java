package com.example.utilsdemo.leetcode.dp;

/**
 * @Author: xy
 * @Date: 2024-09-03 14:49
 * @Description:
 */
public class Solution63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[j][i] == 1) {
                    obstacleGrid[j][i] = 0;
                } else {
                    obstacleGrid[j][i] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[j][i] != 0) {
                    obstacleGrid[j][i] = ((i-1) > 0 ?obstacleGrid[j][i - 1]:0) + ((j-1) > 0 ? obstacleGrid[j-1][i]:0);
                }
            }
        }
        return obstacleGrid[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] dp = {{0,0,0},{0,1,0},{0,0,0}};
        uniquePathsWithObstacles(dp);
    }
}
