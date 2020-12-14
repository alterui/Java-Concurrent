package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/14 3:22 下午
 */
public class ThreadNotifyAllDemo {

    private static final Object resource = new Object();
    public static void main(String[] args) throws Exception{
        Thread threadA = new Thread(() -> {
            synchronized (resource) {
                try {
                    System.out.println("threadA begin wait");
                    resource.wait();
                    System.out.println("threadA end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (resource) {
                try {
                    System.out.println("threadB begin wait");
                    resource.wait();
                    System.out.println("threadB end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            synchronized (resource) {
                System.out.println("threadC begin notify");
                resource.notifyAll();
            }
        });

        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}
