package com.example.utilsdemo.leetcode.array;

import com.example.utilsdemo.leetcode.Hash;
import org.elasticsearch.common.collect.Set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: xy
 * @Date: 2025-03-26 10:09
 * @Description:
 */
public class Solution2829 {
    public static int minimumSum(int n, int k) {
        HashSet<Integer> set = new HashSet();
        int count = 0;
        int num = 1;
        while (count < n) {
            if (!set.contains(k - num)) {
                set.add(num);
                count++;
            }
            num++;
        }
        int result = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            result += iterator.next();
        }
        return result;
    }

    public static int minimumSum2(int n, int k) {
        int result = n * (n + 1) / 2;
        if (n >= k / 2) {
            result += (n - k / 2)*((k - 1)/2);
        }
        return result;
    }

    public static void main(String[] args) {
        int sum = minimumSum2(2, 3);
        System.out.println(sum);
    }
}
