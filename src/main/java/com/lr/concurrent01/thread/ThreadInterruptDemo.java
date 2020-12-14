package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/14 23:29
 */
public class ThreadInterruptDemo {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("thread is running...");
            }
        });

        thread.start();
        Thread.sleep(1000);
        //设置标志仅仅是设置标志线程实际并没有被中断，会继续往执行
        thread.interrupt();
        thread.join();

    }
}
