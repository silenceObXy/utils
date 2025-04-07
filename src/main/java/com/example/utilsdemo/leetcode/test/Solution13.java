package com.example.utilsdemo.leetcode.test;

import java.util.HashMap;

/**
 * @Author: xy
 * @Date: 2024-11-04 11:30
 * @Description:
 */
public class Solution13 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int addV = 0;
        int subV = 0;
        for (int i = 0; i < len; i++) {
            char key1 = s.charAt(i);
            Integer value1 = map.get(key1);
            if (i == len -1) {
                addV += value1;
                break;
            }
            char key2 = s.charAt(i + 1);
            Integer value2 = map.get(key2);
            if (value1 >= value2) {
                addV += value1;
            } else {
                subV += value1;
            }
        }
        return addV - subV;
    }
}
