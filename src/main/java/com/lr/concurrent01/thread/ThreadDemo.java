package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/11 22:52
 */
public class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("当前线程"+Thread.currentThread().getId()+"执行了");
    }

    public static void main(String[] args) {
        new ThreadDemo().start();
    }
}
