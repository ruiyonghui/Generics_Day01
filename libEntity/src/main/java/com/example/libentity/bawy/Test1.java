package com.example.libentity.bawy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) throws Exception {
        method5();
    }

    private static void method5() throws Exception {
        // 1.获取字节码
        Class<Person> clazzP = Person.class;
        //创建对象
        Person person = clazzP.newInstance();
        Method method = clazzP.getMethod("setName", String.class);

        method.invoke(person, "王二");
        System.out.println(person.getName());
    }

    /**
     * 获取属性
     * @throws SecurityException
     * @throws NoSuchFieldException
     */
    private static void method4() throws Exception {
        // 1.获取字节码
        Class<Person> clazzP = Person.class;
        Constructor<Person> constructor = clazzP.getConstructor(String.class);
        Person person = constructor.newInstance("小米");

        Person person2 = constructor.newInstance("赵六");
        Person person3 = constructor.newInstance("王五");

        Field field = clazzP.getDeclaredField("name");// 获取private修饰的属性
        field.setAccessible(true);// 暴力访问
        field.set(person, "大米");

        // 获取person对象里的name属性值

        System.out.println("person" + field.get(person));
    }

    private static void method3() {
        // 获取多个构造方法
        Class<Person> clazzP = Person.class;
        Constructor<?>[] constructors = clazzP.getConstructors();
    }

    private static void method2() throws Exception {
        // 获取构造方法

        Class<Person> clazzP = Person.class;
        Constructor<Person> constructor = clazzP.getConstructor(String.class);
        Person person = constructor.newInstance("小花");
        System.out.println(person.getName());
    }

    private static void method1() throws ClassNotFoundException {
        // 获取字节码的三种方式
        Class clazz1 = Person.class;
        Class clazz2 = new Person("小明").getClass();
        Class clazz3 = Class.forName("com.baway.Person");
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);
    }
}
