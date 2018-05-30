package com.example.libentity.Day020510;

import com.example.libentity.Entity;
import com.example.libentity.day02.Persons;

public class Test {
    public static void main(String[] args) throws Exception {
        Class clazz = Persons.class;
        Entity entity = (Entity) clazz.getAnnotation(Entity.class);
        System.out.println(entity.value());
    }


}
