package com.lr.concurrent05;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liurui
 * @date 2020/12/29 3:40 下午
 */
public class AQSTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
