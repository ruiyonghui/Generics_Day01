package com.example.libentity.bawy;

public class Person {
    private String name;
    public String age;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
