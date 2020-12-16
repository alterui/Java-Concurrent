package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/16 22:36
 */
public class ThreadLocalDemo {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            threadLocal.set("threadOne local variable...");
            print("threadOne");
            System.out.println("remove after threadTwo:"+threadLocal.get());

        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set("threadTwo local variable...");
            print("threadTwo");
            System.out.println("remove after threadTwo:"+threadLocal.get());
        });
        thread1.start();
        thread2.start();

    }

    public static void print(String str) {
        System.out.println(str+":"+threadLocal.get());
        //remove
        threadLocal.remove();
    }


}
