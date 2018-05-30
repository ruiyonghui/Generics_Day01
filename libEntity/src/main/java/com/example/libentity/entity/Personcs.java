package com.example.libentity.entity;

public class Personcs {
    private String name;
    public String age;
    public Personcs() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Personcs(String name) {
        this.name = name;
    }

    public Personcs(String name, String age) {
        this.name = name;
        this.age = age;
    }

}
