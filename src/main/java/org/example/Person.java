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

    public int getAge() {
        return age;
    }

    public String toString(){
        return this.name+" "+this.surname+" - "+this.age+" y.o.";
    }
}
