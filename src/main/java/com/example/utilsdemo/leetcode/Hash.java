package com.example.utilsdemo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author: xy
 * @Date: 2024-11-15 09:35
 * @Description:
 */
public class Hash {
    public boolean canConstruct(String ransomNote, String magazine) {
        int m = ransomNote.length();
        int n = magazine.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < m; i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            char target = t.charAt(i);
            Character character = mapS.get(c);
            if (character != null && character != target) {
                return false;
            }
            Character character2 = mapT.get(target);
            if (character2 != null && character2 != c) {
                return false;
            }
            mapS.put(c, target);
            mapT.put(target, c);
        }
        return true;
    }


    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n != m) {
            return false;
        }
        int[] ints = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            ints[c - 'a'] += 1;
        }
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            ints[c - 'a'] -= 1;
            if (ints[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHappy(int n) {
        if (n < 10 && n != 1) {
            return false;
        }
        LinkedList<Integer> list = new LinkedList<>();
        int total = n;
        while (true) {
            total = dealValue(total);
            if (total == 1) {
                return true;
            }
            if (list.contains(total)) {
                return false;
            }
            list.add(total);
        }
    }

    private static int dealValue(int n) {
        int total = 0;
        while (n >= 10) {
            int v = n % 10;
            n = n / 10;
            total += v * v;
        }
        total += n * n;
        return total;
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int max = 1;
        int lenMax = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - 1 != nums[i - 1]) {
                max = Math.max(max, lenMax);
                lenMax = 1;
            } else {
                lenMax++;
            }
        }
        max = Math.max(max, lenMax);
        return max;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int diff = i - map.getOrDefault(nums[i], -k - 1);
            if (diff <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }


    public static void main(String[] args) {
//        boolean happy = isHappy(19);
//        System.out.println(happy);
        int[] ints = {0,0,-1};
        System.out.println(longestConsecutive(ints));
    }
}
