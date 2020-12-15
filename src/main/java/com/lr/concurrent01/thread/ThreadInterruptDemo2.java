package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/15 22:36
 */
public class ThreadInterruptDemo2 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("thread is："+Thread.currentThread().isInterrupted());
            System.out.println(Thread.currentThread().interrupted());
            System.out.println("thread is："+Thread.currentThread().isInterrupted());


        });

        thread.start();
        thread.interrupt();
        System.out.println("main:"+Thread.interrupted());


    }
}
