package com.lr.concurrent01.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liurui
 * @date 2020/12/14 6:21 下午
 */

public class ThreadSleepDemo {
    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            lock.lock();
            System.out.println("threadA begin sleep");
            try {
                Thread.sleep(5000);
                System.out.println("threadA end sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        });


        Thread threadB = new Thread(() -> {
            lock.lock();
            System.out.println("threadB begin sleep");
            try {
                Thread.sleep(5000);
                System.out.println("threadB end sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        });

        threadA.start();
        threadB.start();
    }

}
