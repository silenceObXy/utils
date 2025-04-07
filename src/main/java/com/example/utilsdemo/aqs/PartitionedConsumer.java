package com.example.utilsdemo.aqs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class PartitionedConsumer {
    private final Map<String, BlockingQueue<String>> partitionQueues = new HashMap<>();

    public void startConsumers(int numConsumers) {
        for (int i = 0; i < numConsumers; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        // 获取一个分区队列
                        BlockingQueue<String> queue = getPartitionQueue();
                        String message = queue.take();
                        processMessage(message);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }).start();
        }
    }

    private BlockingQueue<String> getPartitionQueue() {
        // 这里可以根据消息的某个属性来选择分区队列
        // 例如，根据消息的用户ID
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        String partitionKey = "partition1"; // 简单示例，实际应用中应根据消息属性选择
        return partitionQueues.computeIfAbsent(partitionKey, k -> new LinkedBlockingQueue<>());
    }

    private void processMessage(String message) {
        System.out.println("Processing message: " + message + " on thread: " + Thread.currentThread().getName());
        // 模拟处理时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void enqueueMessage(String message) {
        BlockingQueue<String> queue = getPartitionQueue();
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        PartitionedConsumer consumer = new PartitionedConsumer();
        consumer.startConsumers(3);

        // 生产者线程
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                consumer.enqueueMessage("Message " + i);
            }
        }).start();
    }
}
