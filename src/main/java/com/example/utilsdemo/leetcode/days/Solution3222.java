package com.example.utilsdemo.leetcode.days;

/**
 * @Author: xy
 * @Date: 2024-11-05 11:47
 * @Description:
 */
public class Solution3222 {
    public String losingPlayer(int x, int y) {
        int count = 0;
        while (x >= 1 && y >= 4) {
            x -= 1;
            y -= 4;
            count++;
        }
        return count%2 == 1 ? "Alice" : "Bob";
    }
}
