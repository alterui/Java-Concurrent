package com.lr.concurrent01.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liurui
 * @date 2020/12/11 23:09
 */
public class FutureTaskDemo implements Callable<String> {
    public String call(){
        System.out.println("当前线程"+Thread.currentThread().getId()+"执行了");
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws Exception{
        FutureTaskDemo futureTaskDemo = new FutureTaskDemo();
        FutureTask<String> futureTask = new FutureTask<>(futureTaskDemo);
        Thread thread = new Thread(futureTask);
        thread.start();
        String s = futureTask.get();
        System.out.println(s);
    }
}
