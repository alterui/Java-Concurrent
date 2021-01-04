package com.lr.concurrent01.thread;

/**
 * @author liurui
 * @date 2020/12/16 23:36
 */
public class CodeTest02 {
    public static void main(String[] args) {

        final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Integer integer = threadLocal.get();
        System.out.println(integer);


    }

}
