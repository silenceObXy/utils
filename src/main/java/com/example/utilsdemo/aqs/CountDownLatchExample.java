package com.example.utilsdemo.aqs;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        // 创建一个CountDownLatch实例，计数器初始化为4
        final CountDownLatch latch = new CountDownLatch(4);

        // 创建并启动4个工作线程
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    // 模拟工作线程执行任务
                    System.out.println(Thread.currentThread().getName() + " 正在执行任务...");
                    Thread.sleep(1000); // 模拟任务耗时1秒
                    System.out.println(Thread.currentThread().getName() + " 完成任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 任务完成后，调用countDown方法减少计数器
                    latch.countDown();
                }
            }).start();
        }

        try {
            // 主线程等待，直到计数器归零
            System.out.println("主线程等待所有工作线程完成任务...");
            latch.await();
            System.out.println("所有工作线程已完成任务，主线程继续执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
