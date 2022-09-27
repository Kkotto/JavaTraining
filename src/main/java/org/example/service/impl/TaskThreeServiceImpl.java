package org.example.service.impl;

import org.example.model.Person;
import org.example.service.InfantException;
import org.example.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskThreeServiceImpl implements TaskService {
    private final int PEOPLE_QUANTITY=10;
    private final int MIN_AGE=5;
    private final int MAX_AGE=75;
    @Override
    public void runTask() {
        List<Person> people = new ArrayList<>();
        Random random=new Random();
        for(int i=0; i<PEOPLE_QUANTITY; i++){
            people.add(new Person("Name"+i, "Surname"+i, random.nextInt(MAX_AGE-MIN_AGE)+MIN_AGE));
        }
        for(Person person : people){
            System.out.println(person);
        }
        for(Person person : people){
            if(person.getAge()< person.ADULT_AGE){
                try {
                    throw new InfantException(person.getAge());
                } catch (InfantException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
