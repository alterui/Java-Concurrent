package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/12 23:44
 */
public class App {
    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String[] args) {


        new Thread(() -> {

            synchronized (resourceA) {

                System.out.println("threadB get resourceA lock");

                synchronized (resourceB) {
                    System.out.println("threadB get resourceB lock");
                }

            }
        }).start();
    }
}
