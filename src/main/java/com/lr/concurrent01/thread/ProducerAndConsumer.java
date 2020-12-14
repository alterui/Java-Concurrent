package com.lr.concurrent01.thread;

import java.io.EOFException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liurui
 * @date 2020/12/12 16:59
 */
public class ProducerAndConsumer {
    public static final Integer MAX_SIZE= 5;
    public static final Queue<Integer> queue = new LinkedList<>();


    public void producer(Integer ele) throws Exception {
        synchronized (queue) {
            System.out.println(Thread.currentThread().getName());
            while (queue.size() == MAX_SIZE) {
                queue.wait();
            }
            queue.add(ele);
            System.out.println("生产者正在生产"+ele);
            queue.notifyAll();
        }
    }

    public void consumer() throws Exception{
        synchronized (queue) {

            while (queue.size() ==0) {
              queue.wait();
            }
            Integer poll = queue.poll();
            System.out.println("消费者正在消费" + poll);
            queue.notifyAll();
        }
    }

    public static void main(String[] args) throws Exception{
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(()->{

                try {
                    producerAndConsumer.producer(finalI);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
