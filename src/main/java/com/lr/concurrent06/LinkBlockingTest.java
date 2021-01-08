package com.lr.concurrent06;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liurui
 * @date 2021/1/7 1:58 下午
 */
public class LinkBlockingTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);
        queue.add(1);
    }
}
