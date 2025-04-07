package com.example.utilsdemo.huawei;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @Author: xy
 * @Date: 2025-03-03 16:39
 * @Description:
 */
public class Solution9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int[] ints = new int[end - start + 1];

        // 计算区间内符合条件的数字个数
        int res = findNum(end) - findNum(start - 1);
        System.out.println(res);
    }

    private static int findNum(int num) {
        // 将数字转换成二进制数组，例如 10 -> [1, 0, 1, 0]
        Integer[] binArr = Arrays.stream(Integer.toBinaryString(num).split(""))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        // dp数组: 记忆化搜索，dp[pos][前一位状态1][前两位状态2]
        int[][][] dp = new int[binArr.length][2][2];

        // 从高位开始进行深度优先搜索
        return dfs(0, true, dp, binArr, 0, 0);
    }

    private static int dfs(int pos, boolean lim, int[][][] dp, Integer[] binArr, int p1, int p2) {
        // 递归终止条件：当到达二进制的最后一位，返回1
        if (pos == binArr.length) {
            return 1;
        }

        // 如果不受限制且已经计算过，直接返回记忆化结果
        if (!lim && dp[pos][p1][p2] != 0) {
            return dp[pos][p1][p2];
        }

        int max = lim ? binArr[pos] : 1; // 当前位的最大可选值（0或1）
        int cnt = 0;

        // 递归计算下一位
        cnt += calcRec(max, pos, lim, dp, binArr, p1, p2);

        // 如果不受限制，记录结果到 dp 数组
        if (!lim) {
            dp[pos][p1][p2] = cnt;
        }

        return cnt;
    }

    /**
     * 遍历当前位可能的取值 (0 或 1)，并判断是否合法
     *
     * @param max 当前位的最大值
     * @param pos 当前位置
     * @param lim 是否受限
     * @param dp  记忆化数组
     * @param binArr 二进制数组
     * @param p1 前一位的值
     * @param p2 前两位的值
     * @return 符合条件的数量
     */
    public static int calcRec(int max, int pos, boolean lim, int[][][] dp, Integer[] binArr, int p1, int p2) {
        int sum = 0;
        for (int i = 0; i <= max; i++) { // 当前位的取值 0 或 1
            // 剪枝：若形成 "101" 则跳过
            if (i != 1 || p1 != 0 || p2 != 1) {
                // 继续递归下一位
                sum += dfs(pos + 1, lim && i == max, dp, binArr, i, p1);
            }
        }
        return sum;
    }
}
