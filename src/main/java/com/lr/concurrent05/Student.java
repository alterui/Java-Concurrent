package com.lr.concurrent05;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author liurui
 * @date 2020/12/29 5:41 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;

    public static void main(String[] args) {
        Student student = new Student();
        student.get(student);
        System.out.println("main:"+student.name);

    }


    public void get(Student student) {

         student.name = "3";
        System.out.println("name："+student.name);
    }

}
