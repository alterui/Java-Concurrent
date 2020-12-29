package com.lr.concurrent01.thread;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Function;
import java.util.logging.Handler;

/**
 * @author liurui
 * @date 2020/12/17 2:48 下午
 */
public class Application {
    public static void main(String[] args) {

        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(12);
        list.add(14);
        list.add(15);
        list.add(16);


        Iterator<Integer> iterator = list.iterator();

        Thread thread = new Thread(() -> {
            list.set(1, 999);
            list.remove(3);


        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.forEach(e-> System.out.println(e));

        while (iterator.hasNext()) {
            System.out.println(iterator.next()+"dfsfdsfsdfsdfdsfsdffdsv");
        }

    }
}
