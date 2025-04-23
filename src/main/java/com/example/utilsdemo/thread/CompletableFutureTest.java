package com.example.utilsdemo.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: xy
 * @Date: 2025-04-11 15:56
 * @Description:
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3, (Runnable r) -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });

//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "a", pool)
//                .thenApplyAsync(v -> {
//                    System.out.println("主任务结果" + v);
//                    return "b";
//                }, pool)
//                .thenApplyAsync(v -> {
//                    System.out.println("次任务结果" + v);
//                    return "c";
//                }, pool);
//        System.out.println(future.get());

//        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "a", pool)
//                .thenRunAsync(() -> {
//                    System.out.println("谢谢小星星");
//                    System.out.println("异步执行");
//                }, pool);
//        future.join();

//        CompletableFuture<Void> funtue=CompletableFuture.supplyAsync(()->"a",pool)
//                .thenAcceptAsync(v->{
//                    System.out.println("上一步结果");
//                    System.out.println(v);
//                },pool);
//        funtue.join();

//        CompletableFuture<Integer> future1=CompletableFuture.supplyAsync(()->3,pool);
//        CompletableFuture<Integer> future2=CompletableFuture.supplyAsync(()->6,pool);
//        CompletableFuture<Integer> future3=future1.thenCombineAsync(future2,(m,v)->m*v,pool);
//        System.out.println(future3.get());

        CompletableFuture<Void> future1=CompletableFuture.runAsync(()-> System.out.println("步骤1"),pool);
        CompletableFuture<Void> future2=CompletableFuture.runAsync(()->System.out.println("步骤2"),pool);
        CompletableFuture<Void> future3=future1.runAfterBothAsync(future2,()->System.out.println("步骤3"),pool);
        future3.join();


//
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            return "返回结果";
//        }, pool).handle((result, throwable) -> {
//            if (throwable != null) {
//                return "have exception";
//            }
//            System.out.println("result call");
//            System.out.println(result);
//            return "result:" + result;
//        });
//
//        String result = null;
//        try {
//            result = future.get();
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println(result);
//
//        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
//        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> " World");
//        future1.thenCombine(future2, (s1, s2) -> s1 + s2)
//                .thenAccept(System.out::println);  // 输出 "Hello World"

//        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2);
//        allFutures.thenRun(() -> {
//            String result1 = future1.join();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            String result2 = future2.join();
//            System.out.println(result1);
//            System.out.println(result2);
//        });

    }
}
