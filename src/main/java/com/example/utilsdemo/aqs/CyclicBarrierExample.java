package com.example.utilsdemo.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        // 创建一个CyclicBarrier实例，设置参与的线程数为4
        final CyclicBarrier barrier = new CyclicBarrier(4, () -> {
            System.out.println("所有线程已到达屏障点，继续执行...");
        });

        // 创建并启动4个工作线程
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    // 模拟工作线程执行任务
                    System.out.println(Thread.currentThread().getName() + " 正在执行任务...");
                    Thread.sleep(1000); // 模拟任务耗时1秒
                    System.out.println(Thread.currentThread().getName() + " 完成任务，等待其他线程...");

                    // 等待其他线程到达屏障点
                    barrier.await();

                    // 所有线程到达屏障点后继续执行
                    System.out.println(Thread.currentThread().getName() + " 继续执行后续任务...");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
