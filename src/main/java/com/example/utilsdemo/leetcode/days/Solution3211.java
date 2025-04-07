package com.example.utilsdemo.leetcode.days;

import org.elasticsearch.common.collect.Set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: xy
 * @Date: 2024-10-29 09:25
 * @Description:
 */
public class Solution3211 {
    public static List<String> validStrings(int n) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        if (n==1) {
            list.add("0");
            list.add("1");
            return list;
        }
        for (int i = 1; i < n; i++) {
            addStr("0", n, set);
            addStr("1", n, set);
        }
        list.addAll(set);
        return list;
    }

    private static void addStr(String bu, int n, HashSet<String> list) {
        int len = bu.length();
        char c = bu.charAt(len - 1);
        if (len == n - 1) {
            if (c == '1') {
                list.add(bu + "0");
                list.add(bu + "1");
            } else {
                list.add(bu + "1");
            }
        } else {
            if (c == '1') {
                addStr(bu + "0", n, list);
                addStr(bu + "1", n, list);
            } else {
                addStr(bu + "1", n, list);
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = validStrings(3);
        System.out.println(list);
    }
}
