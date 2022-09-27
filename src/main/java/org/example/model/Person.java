package org.example.model;

public class Person {
    private final String name;
    private String surname;
    private int age;

    public final int ADULT_AGE=18;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public String toString(){
        return this.name+" "+this.surname+" is "+this.age+" y.o.";
    }

}
