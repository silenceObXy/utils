package com.example.utilsdemo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: xy
 * @Date: 2024-11-11 15:24
 * @Description:
 */
public class Matrix {
    //36.有效数独
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> setX = new HashSet<>();
            HashSet<Character> setY = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if ('.' != board[i][j] && !setX.add(board[i][j])) {
                    return false;
                }
                if ('.' != board[j][i] && !setY.add(board[j][i])) {
                    return false;
                }
            }
        }

        int[][] index = {{1, 1}, {1, 4}, {1, 7}, {4, 1}, {4, 4}, {4, 7}, {7, 1}, {7, 4}, {7, 7}};
        int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int[] ints : index) {
            HashSet<Character> set = new HashSet<>();
            for (int[] dire : direction) {
                char target = board[ints[0] + dire[0]][ints[1] + dire[1]];
                if ('.' != target && !set.add(target)) {
                    return false;
                }
            }

        }
        return true;
    }


    public static int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int total = 0;
        for (int i = 0; i < n; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int j = i; j < n; j++) {
                count0 += s.charAt(j) == '0' ? 1 : 0;
                count1 += s.charAt(j) == '1' ? 1 : 0;
                if (count0 > k && count1 > k) {
                    break;
                } else {
                    total++;
                }
            }
        }
        return total;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;//行数
        int n = matrix[0].length;//列数
        boolean[][] map = new boolean[m][n];
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(matrix[0][0]);
        map[0][0] = true;
        int x = 0;
        int y = 0;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        //默认方向
        int[] dire = {1, 0};
        while (true) {
            if (x + dire[1] >= 0 && y + dire[0] >= 0 && x + dire[1] < m && y + dire[0] < n && !map[x + dire[1]][y + dire[0]]) {
                x += dire[1];
                y += dire[0];
                ans.add(matrix[x][y]);
                map[x][y] = true;
            } else {
                for (int i = 0; i < 4; i++) {
                    x += direction[i][1];
                    y += direction[i][0];
                    if (x >= 0 && y >= 0 && x < m && y < n && !map[x][y]) {
                        ans.add(matrix[x][y]);
                        map[x][y] = true;
                        dire = direction[i];
                        break;
                    } else {
                        x -= direction[i][1];
                        y -= direction[i][0];
                    }
                    if (i == 3) {
                        return ans;
                    }
                }
            }
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return;
        }
        int num = 0;
        //斜对角折叠
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                num = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = num;
            }
        }
        //竖中线折叠
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                num = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = matrix[i][j];
                matrix[i][j] = num;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ints = new int[m + n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    ints[i] = 1;
                    ints[m + j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ints[i] == 1 || ints[m + j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] ints = new int[m][n];
        int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int total = 0;
                for (int[] ints1 : direction) {
                    if (i + ints1[0] < m && j + ints1[1] < n && i + ints1[0] >= 0 && j + ints1[1] >= 0) {
                        total += board[i + ints1[0]][j + ints1[1]];
                    }
                }
                if (total < 2) {
                    ints[i][j] = 0;
                } else if (total == 2) {
                    ints[i][j] = board[i][j];
                } else if (total == 3) {
                    ints[i][j] = 1;
                } else {
                    ints[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ints[i][j];
            }
        }
    }

    public static void main(String[] args) {
//        char[][] board = {{'9', '.', '.', '6', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
//        System.out.println(isValidSudoku(board));

//        countKConstraintSubstrings("10101", 1);

        int[][] ints = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
//        System.out.println(spiralOrder(ints));
//        rotate(ints);
        gameOfLife(ints);
    }
}
