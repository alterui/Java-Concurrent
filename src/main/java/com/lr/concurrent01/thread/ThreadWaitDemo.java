package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/12 20:25
 */
public class ThreadWaitDemo {
    public static void main(String[] args) {
        ThreadWaitDemo threadWaitDemo = new ThreadWaitDemo();
        Thread thread = new Thread(() -> {
            synchronized (threadWaitDemo) {
                try {

                        System.out.println("正在wait执行....");
                        threadWaitDemo.wait();
                        System.out.println("正在wait执行结束....");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            synchronized (threadWaitDemo) {
                threadWaitDemo.notifyAll();
            }
        }).start();

    }
}
