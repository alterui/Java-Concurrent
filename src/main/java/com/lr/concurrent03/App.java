package com.lr.concurrent03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author liurui
 * @date 2020/12/25 4:39 下午
 */
public class App {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> getList() {
        return list;
    }

    public void setList(Integer integer) {
        list.add(integer);
    }

    public CowList iterator() {
        return new CowList(getList());
    }
    public static void main(String[] args) {
        App app = new App();

        app.setList(1);
        app.setList(2);
        app.setList(3);

        CowList cowList = new CowList(app.getList());

        System.out.println(cowList.snapshot.size());
        app.setList(4);
        System.out.println(cowList.snapshot.size());



    }

    static final class CowList  {
        private final List<Integer> snapshot;

        private CowList(List<Integer> list) {

            this.snapshot = list;
        }

        public List<Integer> getSnapshot() {
            return snapshot;
        }

    }
}
