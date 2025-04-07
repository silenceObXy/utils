package com.example.utilsdemo.leetcode;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Author: xy
 * @Date: 2024-12-13 15:25
 * @Description:
 */
public class Stuck {
    public static boolean isValid(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int v = s.charAt(i);
            if (stack.size() != 0 && (v == stack.peek() + 1 || v == stack.peek() + 2)) {
                stack.pop();
            } else {
                stack.add(v);
            }
        }
        return stack.size() == 0;
    }

    public static String simplifyPath(String path) {
        String[] list = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String value : list) {
            if ("..".equals(value)) {
                if (stack.size() != 0) {
                    stack.pop();
                }
            } else if (!"".equals(value) && !".".equals(value)) {
                stack.add(value);
            }
        }
        String result = String.join("/", stack);
        return "/" + result;
    }


    public static int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String target = tokens[i];
            Integer v = null;
            if ("+".equals(target)) {
                v = stack.pop() + stack.pop();
            } else if ("-".equals(target)) {
                Integer peek1 = stack.pop();
                Integer peek2 = stack.pop();
                v = peek2 - peek1;
            } else if ("*".equals(target)) {
                v = stack.pop() * stack.pop();
            } else if ("/".equals(target)) {
                Integer peek1 = stack.pop();
                Integer peek2 = stack.pop();
                v = peek2 / peek1;
            } else {
                v = Integer.valueOf(target);
            }
            stack.add(v);
        }
        return stack.pop();
    }

    public static void main(String[] args) {
//        String v = "/home/user/Documents/../Pictures";
//        isValid(v);
//        simplifyPath(v);
        String[] s = {"4","13","5","/","+"};
        evalRPN(s);
    }
}
