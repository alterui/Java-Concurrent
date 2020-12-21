package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/17 2:40 下午
 */
public class DeadLockTest {
    //创建两个资源
    private static final Object sourceA = new Object();
    private static final Object sourceB = new Object();
    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            synchronized (sourceA) {
                System.out.println("线程A获取到sourceA...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (sourceB) {
                    System.out.println("线程A获取到sourceB");
                }
            }
        });


        Thread threadB = new Thread(() -> {
            synchronized (sourceB) {
                System.out.println("线程B获取到sourceB...");
                synchronized (sourceA) {
                    System.out.println("线程B获取到sourceA");
                }
            }
        });

        threadA.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();




    }
}
