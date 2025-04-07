package com.example.utilsdemo.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    private static final int COUNT = 10;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();
    private static int current = 0; // 0 for A, 1 for B, 2 for C

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> print("A", 0, conditionA, conditionB));
        Thread threadB = new Thread(() -> print("B", 1, conditionB, conditionC));
        Thread threadC = new Thread(() -> print("C", 2, conditionC, conditionA));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static void print(String name, int target, Condition currentCondition, Condition nextCondition) {
        for (int i = 0; i < COUNT; i++) {
            lock.lock();
            try {
                if (current != target) {
                    currentCondition.await();
                }
                System.out.println(name);
                current = (current + 1) % 3;
                nextCondition.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }
}
