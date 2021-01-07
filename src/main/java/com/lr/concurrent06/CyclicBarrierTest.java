package com.lr.concurrent06;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liurui
 * @date 2021/1/5 6:31 下午
 */
public class CyclicBarrierTest {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(23);
    public static void main(String[] args) throws Exception{
        new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        cyclicBarrier.await();

        System.out.printf("2");
    }
}
