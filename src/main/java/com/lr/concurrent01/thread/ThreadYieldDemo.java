package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/15 6:05 下午
 */
public class ThreadYieldDemo implements Runnable {

    public ThreadYieldDemo(){
        Thread thread = new Thread(this);
        thread.start();
    }
    public static void main(String[] args) {
        new ThreadYieldDemo();
        new ThreadYieldDemo();
        new ThreadYieldDemo();

    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread() + "yield cpu...");
                Thread.yield();
            }
            System.out.println(Thread.currentThread() + "is over");
        }
    }
}
