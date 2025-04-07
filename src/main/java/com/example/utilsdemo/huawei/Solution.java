package com.example.utilsdemo.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: xy
 * @Date: 2025-02-28 09:32
 * @Description:
 */
public class Solution {
    //汽水瓶
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            if (a == 0) {
//                return;
//            }
//            System.out.println(a / 2);
//        }
//    }

/*明明的随机数*/
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int nums = in.nextInt();
//        if (nums == 0) {
//            return;
//        }
//        HashSet<Integer> set = new HashSet<>();
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int a = in.nextInt();
//            set.add(a);
//        }
//        set.stream().sorted().forEach(System.out::println);
//    }

    //进制转换
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.next();
        String value = target.substring(2);
        int len = value.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            int abs = len - i;
            if (value.charAt(i) >= 48 && value.charAt(i) <= 57) {
                result += (value.charAt(i) - 48) * Math.pow(16, abs - 1);
            } else {
                result += (value.charAt(i) - 55) * Math.pow(16, abs - 1);
            }
        }
        System.out.println(result);
    }
}
