package com.lr.concurrent01.thread;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liurui
 * @date 2020/12/23 22:24
 */
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private transient String address;

    public static void main(String[] args) {
        User user = new User(1, "tom", "shanghai");
        System.out.println(JSON.toJSONString(user));
    }
}
