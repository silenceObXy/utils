package com.example.utilsdemo.aqs;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SingleThreadConsumer {
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public void startConsumer() {
        new Thread(() -> {
            while (true) {
                try {
                    String message = queue.take();
                    processMessage(message);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }

    private void processMessage(String message) {
        System.out.println("Processing message: " + message);
        // 模拟处理时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void enqueueMessage(String message) {
        try {
            queue.put(message);
            System.out.println("Enqueued message: " + message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        SingleThreadConsumer consumer = new SingleThreadConsumer();
        consumer.startConsumer();

        // 生产者线程
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                consumer.enqueueMessage("Message " + i);
            }
        }).start();
    }
}
