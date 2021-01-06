package com.lr.concurrent05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author liurui
 * @date 2021/1/5 22:37
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(30);
    public static void main(String[] args) {

        for (int i = 0; i< THREAD_COUNT; i++) {
            threadPool.execute(() -> {
                try {
                    s.acquire();
                    Thread.sleep(1000);
                    System.out.println("save data");
                    s.release();
                } catch (InterruptedException e) {
                }
            });
        }
        threadPool.shutdown();
    }
}
