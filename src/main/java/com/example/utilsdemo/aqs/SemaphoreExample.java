package com.example.utilsdemo.aqs;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        // 创建一个Semaphore实例，设置许可数量为2
        final Semaphore semaphore = new Semaphore(2);

        // 创建并启动多个打印任务线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    // 获取一个许可
                    System.out.println(Thread.currentThread().getName() + " 尝试获取许可...");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 获取到许可，开始打印...");

                    // 模拟打印任务耗时1秒
                    Thread.sleep(1000);

                    System.out.println(Thread.currentThread().getName() + " 打印完成，释放许可...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放许可
                    semaphore.release();
                }
            }).start();
        }
    }
}
