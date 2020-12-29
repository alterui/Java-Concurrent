package com.lr.concurrent03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liurui
 * @date 2020/12/25 5:25 下午
 */
public class Main {
    public static void main(String[] args) {
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        System.out.println(list.size());
    }
}
