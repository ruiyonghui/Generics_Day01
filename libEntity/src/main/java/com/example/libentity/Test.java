package com.example.libentity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Class clazz = Person.class;
        Entity entity = (Entity) clazz.getAnnotation(Entity.class);
        System.out.println(entity.value());

        Class clazzTest = Test.class;
        Method method = clazzTest.getMethod("method1");
        Entity entityMethod = (Entity) method
                .getAnnotation(Entity.class);
        System.out.println(entityMethod.value());

        Class clazzT = Test.class;
        // 获取方法
        Method method2 = clazzT.getMethod("login", String.class, String.class);
        Annotation[][] parameterAnnotations = method2.getParameterAnnotations();
        Field f1 = (Field) parameterAnnotations[0][0];
        Field f2 = (Field) parameterAnnotations[1][0];
        System.out.println(f1.value() + " " + f2.value());
    }

    @Entity(retention = MyRetentionPolicy.CLASS, str = { "1" }, value = "2")
    public static void method1() {

    }

    public void login(@Field("mobile") String mobile, @Field("password") String password) {
    }
}
