package com.lr.concurrent01.thread;

/**
 * 当前线程调用共享变量的wait方法后只会释放当前共享变量上的锁，如果
 * 还持有其他锁
 * @author liurui
 * @date 2020/12/12 22:47
 */
public class ThreadWaitReleaseLockDemo {
    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread threadA = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("threadA get resourceA lock..");
                synchronized (resourceB) {
                    System.out.println("threadA get resourceB lock");

                    //线程A堵塞，并释放resourceA的锁
                    try {
                        System.out.println("threadA release resourceA lock");
                        resourceA.wait();
                        //为什么线程B中resourceA.notify()，下面这行代码不执行呢
                        System.out.println("线程A继续执行....");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        Thread threadB = new Thread(() -> {

            synchronized (resourceA) {
                //notify()方法必须等待执行完代码块，放弃锁之后才起作用。
                resourceA.notify();
                System.out.println("threadB get resourceA lock");
                System.out.println("threadB try  get resourceB lock");

                synchronized (resourceB) {
                    System.out.println("threadB get resourceB lock");
                }
            }



        });

        threadA.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("main end");

    }

}
