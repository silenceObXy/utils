package com.example.utilsdemo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: xy
 * @Date: 2025-03-04 17:55
 * @Description:
 */
public class ThreadLocalTest {
    private static final ThreadLocal<byte[]> localVar = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(() -> {
            localVar.set(new byte[10 * 1024 * 1024]); // 10MB
            System.out.println("设置ThreadLocal");
        });

        executorService.execute(() -> {
            System.out.println("线程复用，未手动清理ThreadLocal");
        });

        executorService.shutdown();
    }

}
