package com.example.utilsdemo.huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: xy
 * @Date: 2025-03-03 10:49
 * @Description:
 */
public class Solution6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : text) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<Map.Entry<String, Integer>> collect = map.entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (Objects.equals(o1.getValue(), o2.getValue())) {
                            return o1.getKey().length() - o2.getKey().length() == 0 ? o1.getKey().compareTo(o2.getKey()) :
                                    o1.getKey().length() - o2.getKey().length();
                        } else {
                            return o2.getValue() - o1.getValue();
                        }
                    }
                }).collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : collect) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                builder.append(key).append(" ");
            }
        }
        System.out.println(builder.toString().trim());
    }
}
