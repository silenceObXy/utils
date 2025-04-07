package com.example.utilsdemo.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: xy
 * @Date: 2025-02-10 17:33
 * @Description:
 */
public class Aqs {
    public static void test() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            try {
                    Thread.sleep(1000);
                    System.out.println("线程" + i +"执行完毕");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("Hello world!");
    }

    public static void main(String[] args) {
        test();
        System.out.println("Hello world!");
    }
}
