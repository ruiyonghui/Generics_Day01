package com.example.libentity.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test01 {
    public static void main(String[] args) throws Exception {
        method1();
    }

    private static void method1() throws Exception  {
        // 1.获取字节码
        Class<Personcs> clazzP = Personcs.class;
        Constructor<Personcs> constructor = clazzP.getConstructor(String.class);
        Personcs person = constructor.newInstance("ruiyonghui");
        Constructor<Personcs> constructor2 = clazzP.getConstructor(String.class,String.class);
        Personcs person1 = constructor2.newInstance("ruiyonghui","2");
        System.out.println(person.getName());
        System.out.println(person1.getAge());




    }

}
