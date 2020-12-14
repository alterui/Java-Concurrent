package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/14 6:00 下午
 */
public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("threadOne over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadTwo = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("thread two over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();

        System.out.println("main over");
    }
}
