package com.lr.concurrent05;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liurui
 * @date 2020/12/29 3:40 下午
 */
public class AQSTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(200,true);
        for (int i = 0; i < 99; i++) {
            int finalI = i;
            new Thread(()->{
                queue.add(finalI);
            }).start();
        }

        Thread.sleep(3000);
        System.out.println(queue.size());
    }
}
