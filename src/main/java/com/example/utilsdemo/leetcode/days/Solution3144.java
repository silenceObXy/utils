package com.example.utilsdemo.leetcode.days;

import sun.applet.Main;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: xy
 * @Date: 2024-08-28 09:13
 * @Description:
 */
public class Solution3144 {
    static final int INF = 0x3f3f3f3f;

    public static int minimumSubstringsInPartition(String s) {
        int length = s.length();
        int[] ints = new int[length + 1];
        Arrays.fill(ints, INF);
        ints[0] = 0;
        for (int i = 1; i <= length; i++) {
            //记录各个元素出现的次数
            HashMap<Character, Integer> map = new HashMap<>();
            int maxCount = 0;
            for (int j = i; j >= 1; j--) {
                char c = s.charAt(j - 1);
                //插入统计集合
                map.put(c, map.getOrDefault(c, 0) + 1);
                //寻找最大值
                maxCount = Math.max(maxCount, map.getOrDefault(c, 0));

                int charNum = maxCount * map.size();
                //出现最大次数*元素数等于所有元素出现的总和，则表示各个元素出现的次数相同
                if (charNum == (i-j+1) && ints[j - 1] != INF) {
                    ints[i] = Math.min(ints[i], ints[j - 1] + 1);
                }
            }
        }
        return ints[length];
    }

    public static void main(String[] args) {
        String s = "fabccddg";
        int i = minimumSubstringsInPartition(s);
        System.out.println(i);
    }
}
