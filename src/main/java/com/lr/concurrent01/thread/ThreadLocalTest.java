package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/17 3:35 下午
 */
public class ThreadLocalTest {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            threadLocal.set("thread1");

        });

        Thread thread = new Thread(() -> {
            String s = threadLocal.get();
            System.out.println(s);
        });

        thread1.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.start();


    }
}
