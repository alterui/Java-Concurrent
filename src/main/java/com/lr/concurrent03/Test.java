package com.lr.concurrent03;

import java.util.Arrays;
import java.util.ListIterator;

/**
 * @author liurui
 * @date 2020/12/25 5:52 下午
 */
public class Test {


    public static void main(String[] args) {
        Object[] objects = new Object[]{2, 4};

        COWIterator cowIterator = new COWIterator(objects);

        System.out.println(cowIterator.snapshot.length);

      /*  int len = objects.length;
        Object[] newElements = Arrays.copyOf(objects, len + 1);
        newElements[len] = 4;

        objects = newElements;
        System.out.println(objects.length);*/

        objects = new Object[]{2, 4,6};
        System.out.println(cowIterator.snapshot.length);

    }

    static final class COWIterator {

        private final Object[] snapshot;


        private COWIterator(Object[] elements) {
            snapshot = elements;
        }

    }
}
