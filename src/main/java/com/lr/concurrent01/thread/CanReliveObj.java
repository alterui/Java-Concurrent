package com.lr.concurrent01.thread;

/**
 * 测试Object类中finalize()方法
 * 对象复活场景
 *
 * @author: 陌溪
 * @create: 2020-07-12-11:06
 */
public class CanReliveObj {
    static CanReliveObj obj2 = new CanReliveObj();
    static CanReliveObj obj = new CanReliveObj();
    static CanReliveObj obj1 = new CanReliveObj();


    public void print() {
        System.out.println(this==obj);
        System.out.println(this==obj1);
        System.out.println(this==obj2);
    }
    public static void main(String[] args) {
        obj.print();

    }
}