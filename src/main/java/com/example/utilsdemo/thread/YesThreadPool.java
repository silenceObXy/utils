package com.example.utilsdemo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

/**
 * @Author: xy
 * @Date: 2024-05-31 14:45
 * @Description:
 */
public class YesThreadPool {
    BlockingDeque<Runnable> taskQueue; // 任务队列
    List<YesThread> threads; // 线程队列

    public YesThreadPool(int threadSize, BlockingDeque taskQueue) {
        this.taskQueue = taskQueue;
        threads = new ArrayList<>(threadSize);
        for (int i = 0; i < threadSize; i++) {
            YesThread thread = new YesThread("线程" + i);
            thread.start();
            threads.add(thread);
        }
    }

    public void execute(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class YesThread extends Thread {
        public YesThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            while (true) {
                Runnable task = null;
                try {
                    task = taskQueue.take();
                } catch (InterruptedException e) {
                    System.out.println("线程池中线程的数量:" + Thread.activeCount());
                }
                task.run();
            }
        }
    }
}
