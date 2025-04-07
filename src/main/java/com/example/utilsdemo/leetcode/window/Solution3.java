package com.example.utilsdemo.leetcode.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: xy
 * @Date: 2024-11-05 16:03
 * @Description:
 */
public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int ans = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < n) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            while (map.get(s.charAt(end)) == 2) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("aab");
    }
}
