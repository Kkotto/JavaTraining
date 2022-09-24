package org.example;

public class Person {
    private String name;
    private String surname;
    private int age;

    public final int ADULT_AGE=18;

    Person(){

    }

    Person(String name, String surname, int age){
        this.name=name;
        this.surname=surname;
        this.age=age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
