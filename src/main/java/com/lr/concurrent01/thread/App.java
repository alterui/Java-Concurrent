package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/12 23:44
 */
public class App {
    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String[] args) {


        Thread thread = new Thread(() -> {

            synchronized (resourceA) {

                System.out.println("threadB get resourceA lock");

                try {
                    resourceA.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main over、、");


    }
}
