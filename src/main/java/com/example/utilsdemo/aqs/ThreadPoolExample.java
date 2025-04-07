package com.example.utilsdemo.aqs;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池，核心线程数和最大线程数均为3
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 使用CompletableFuture提交多个任务到线程池
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            CompletableFuture.runAsync(() -> {
                System.out.println("任务 " + taskId + " 开始执行，线程: " + Thread.currentThread().getName());
                try {
                    // 模拟任务耗时1秒
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务 " + taskId + " 完成，线程: " + Thread.currentThread().getName());
            }, executorService)
            .thenRun(() -> {
                System.out.println("任务 " + taskId + " 的后续操作，线程: " + Thread.currentThread().getName());
            })
            .exceptionally(ex -> {
                System.out.println("任务 " + taskId + " 发生异常: " + ex.getMessage());
                return null;
            });
        }

        // 关闭线程池
        executorService.shutdown();
        try {
            // 等待所有任务完成
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务已完成，线程池已关闭");
    }
}
