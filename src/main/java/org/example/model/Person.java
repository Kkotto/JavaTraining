package org.example.model;

public class Person {
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age){
        this.name=name;
        this.surname=surname;
        this.age=age;
    }

    @Override
    public String toString(){
        return String.format("%s %s is %d y.o.", this.name, this.surname, this.age);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
