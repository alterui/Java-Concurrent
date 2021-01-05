package com.lr.concurrent05;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author liurui
 * @date 2021/1/5 1:54 下午
 */
public class Item implements Delayed {

    private long time;
    private String name;

    public Item(String name, long time, TimeUnit unit) {
        this.name = name;
        this.time = System.currentTimeMillis() + (time > 0 ? unit.toMicros(time) : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return time - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        Item item = (Item)o;
        long diff = this.time - item.time;
        if (diff <= 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
