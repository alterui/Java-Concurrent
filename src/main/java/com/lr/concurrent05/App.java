package com.lr.concurrent05;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2021/1/4 9:34 上午
 */
public class App {
    public static void main(String[] args) {

        Object[] arr = new Object[10];
        arr[0] = new Integer(1);
        for (Object a : arr) {
            System.out.println(a);
        }


    }
}
