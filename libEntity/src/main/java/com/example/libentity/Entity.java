package com.example.libentity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import sun.reflect.generics.repository.MethodRepository;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Entity {

    String value();

    int pid() default 1;
    MyRetentionPolicy retention();
    String[] str();


}
