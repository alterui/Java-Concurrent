package com.lr.concurrent05;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author liurui
 * @date 2021/1/4 9:34 上午
 */
public class App {
    public static void main(String[] args) {
        Student student1 = new Student("1");
        Student student2 = new Student("1");
        System.out.println(student1.equals(student2));
    }
}
