package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/11 23:06
 */

public class RunnableDemo implements Runnable {
    public void run() {
        System.out.println("当前线程"+Thread.currentThread().getId()+"执行了");
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();
    }
}
