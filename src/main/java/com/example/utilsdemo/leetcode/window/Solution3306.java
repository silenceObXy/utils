package com.example.utilsdemo.leetcode.window;

import org.elasticsearch.common.collect.Set;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xy
 * @Date: 2025-03-13 16:51
 * @Description:
 */
public class Solution3306 {
    public static long countOfSubstrings(String word, int k) {
        int len = word.length();
        if (len < k + 5) {
            return 0;
        }
        java.util.Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for (int left = 0; left < len - k - 4; left++) {
            HashMap<Character, Integer> map = new HashMap<>();
            int right = left;
            int unMaster = 0;
            while (right < len && !(unMaster >= k && !set.contains(word.charAt(right)))) {
                char c = word.charAt(right);
                if (set.contains(c)) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                } else {
                    unMaster++;
                }
                if (map.size() >= 5 && unMaster == k) {
                    count++;
                }
                right++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(countOfSubstrings("aeioqq", 1));
    }
}
