package com.example.utilsdemo.huawei;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-02-28 14:46
 * @Description:
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        int result = findWays(a, b);
        System.out.println(result);
    }

    private static int findWays(String a, String b) {
        int length = a.length();
        int len = b.length();
        if (len > length) {
            return 0;
        }
        boolean[] booleans = new boolean[length];
        boolean flag = true;
        int count = 0;
        while (flag) {
            int first = 0;
            int last = 0;
            while (first < length && last < len) {
                if (!booleans[first] && a.charAt(first) == b.charAt(last)) {
                    booleans[first] = true;
                    last++;
                }
                first++;
            }
            //未能覆盖到全部
            if (last != len) {
                flag = false;
            } else {
                count++;
            }
        }
        return count;
    }
}
