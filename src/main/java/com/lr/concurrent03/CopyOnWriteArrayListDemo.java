package com.lr.concurrent03;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * @author liurui
 * @date 2020/12/25 11:54 上午
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(12);
        list.add(11);
        list.add(13);

        Iterator<Integer> iterator = list.iterator();

        list.add(10000);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }




}
