package com.kkotto.service.impl;

import com.kkotto.model.Person;
import com.kkotto.service.TaskService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TaskTwoServiceImpl implements TaskService {
    private final int PEOPLE_QUANTITY = 10;

    @Override
    public void runTask() {
        List<Person> peopleList = generatePeople();
        peopleList = peopleList.stream()
                .sorted(Comparator.comparingInt(Person::getBornYear))
                .collect(Collectors.toList());
        peopleList.forEach(System.out::println);
    }

    private List<Person> generatePeople() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < PEOPLE_QUANTITY; i++) {
            personList.add(generatePerson(i));
        }
        return personList;
    }

    private Person generatePerson(int indexNumber) {
        Random random = new Random();
        int minBornYear = 1950, maxBornYear = 2022;
        int personBornYear = random.nextInt(maxBornYear - minBornYear) + minBornYear;
        if (random.nextBoolean()) {
            return new Person.Builder().addName("Name" + indexNumber).addYear(personBornYear).build();
        } else {
            return new Person.Builder().addName("Name" + indexNumber).addSurname("Surname" + indexNumber).addYear(personBornYear).build();
        }
    }
}
