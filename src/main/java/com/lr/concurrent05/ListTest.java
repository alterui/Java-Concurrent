package com.lr.concurrent05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author liurui
 * @date 2020/12/31 3:23 下午
 */
public class ListTest {
    public static void main(String[] args) {
        // 用CountDownLatch来计数，其主要有两个方法
        // 1是await，使当前线程暂停
        // 2是countDown,使当前计数器减1，如果计数器减为0，则暂停的线程可以继续执行
        CountDownLatch latch = new CountDownLatch(1);
        // new了一个ArrayList
        ArrayList<Object> list = new ArrayList<>(10);
        // 定义了线程操作，先调用latch的await方法等待计数器变成0
        // 然后执行list.add方法;
        Runnable runnable = () -> {
            try {
                latch.await();
                list.add(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        // 循环1000次，新建1000个线程
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
        // 这里调用latch.countDown方法，让计数器减为0，则所有暂停的线程都可以执行
        try {
            latch.countDown();
            // 主线程暂停3秒，让子线程可以执行完
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出最后执行完arrayList里面的个数
        System.out.println(list.size());

    }
}
