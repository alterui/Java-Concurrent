package com.lr.concurrent01.thread;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liurui
 * @date 2020/12/14 2:51 下午
 */
public class ThreadWaitInterruptDemo {
    private static final Object object = new Object();
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            synchronized (object) {
                System.out.println("thread start...");
                try {
                    object.wait(2000,99999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread end...");
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("interrupt start");

        System.out.println("interrupt end");

    }
}
