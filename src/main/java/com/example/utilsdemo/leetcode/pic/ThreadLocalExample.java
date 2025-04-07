package com.example.utilsdemo.leetcode.pic;

public class ThreadLocalExample {
    // 创建一个ThreadLocal变量，存储Integer类型的值
    private static final ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // 创建并启动多个线程
        Thread thread1 = new Thread(() -> {
            // 设置线程本地变量的值
            threadLocalValue.set(10);
            System.out.println("Thread 1: " + threadLocalValue.get());
        });

        Thread thread2 = new Thread(() -> {
            // 设置线程本地变量的值
            threadLocalValue.set(20);
            System.out.println("Thread 2: " + threadLocalValue.get());
        });

        thread1.start();
        thread2.start();

        // 主线程也可以有自己的线程本地变量
        threadLocalValue.set(30);
        System.out.println("Main Thread: " + threadLocalValue.get());
    }
}
