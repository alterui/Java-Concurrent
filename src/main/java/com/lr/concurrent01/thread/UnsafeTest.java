package com.lr.concurrent01.thread;

import sun.misc.Unsafe;

/**
 * @author liurui
 * @date 2020/12/21 2:23 下午
 */
public class UnsafeTest {
    public synchronized void helloA() {
        System.out.println("hello A");
    }

    public synchronized void helloB() {
        System.out.println("hello B");
        helloA();
    }

    public static void main(String[] args) {
        UnsafeTest test = new UnsafeTest();
        test.helloB();
    }

}
