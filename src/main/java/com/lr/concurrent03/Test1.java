package com.lr.concurrent03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liurui
 * @date 2020/12/25 5:52 下午
 */
public class Test1 {


    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(3);

        COWIterator cowIterator = new COWIterator(list);

        System.out.println(cowIterator.snapshot.size());

      /*  int len = objects.length;
        Object[] newElements = Arrays.copyOf(objects, len + 1);
        newElements[len] = 4;

        objects = newElements;
        System.out.println(objects.length);*/


        List list1 = new ArrayList();
        list1.add(2);
        list1.add(2);
        list1.add(2);
        list1.add(2);



        list = list1;

        list.add(23233);
        list.forEach(e-> System.out.println("e:"+e));

        System.out.println(cowIterator.snapshot.size());

    }

    static final class COWIterator {

        private final List snapshot;


        private COWIterator(List elements) {
            snapshot = elements;
        }

    }
}
