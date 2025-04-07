package com.example.utilsdemo.leetcode.tree;

public class WaitNotifyExample {
    private static final Object lock = new Object();
    private static boolean taskCompleted = false;

    public static void main(String[] args) {
        Thread workerThread = new Thread(() -> {
            System.out.println("Worker thread started.");
            try {
                // Simulate some work
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                taskCompleted = true;
                System.out.println("Task completed. Notifying waiting thread.");
                lock.notify();
            }
        });

        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                while (!taskCompleted) {
                    try {
                        System.out.println("Waiting thread is waiting for the task to complete.");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Waiting thread is notified and resumes execution.");
            }
        });

        workerThread.start();
        waitingThread.start();
    }
}
