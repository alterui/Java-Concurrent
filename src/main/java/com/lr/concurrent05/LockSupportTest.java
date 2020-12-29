package com.lr.concurrent05;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liurui
 * @date 2020/12/29 9:25 上午
 */
public class LockSupportTest {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("child thread begin park!");
            LockSupport.park();
            System.out.println("child thread unpark!");
        });

        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread begin unpark!");

        thread.interrupt();
        LockSupport.unpark(thread);
    }
}
