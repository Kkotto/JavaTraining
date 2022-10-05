package org.example.service.impl;

import org.example.model.Person;
import org.example.service.TaskService;

import java.util.*;
import java.util.stream.Collectors;

public class TaskOneServiceImpl implements TaskService {
    private final int PEOPLE_QUANTITY = 100;
    private final int MIN_AGE = 15;
    private final int MAX_AGE = 30;
    private final int SELECTED_AGE = 21;

    @Override
    public void runTask() {
        Random random = new Random();
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < PEOPLE_QUANTITY; i++) {
            people.add(new Person("Name" + random.nextInt(MAX_AGE),
                    "Surname" + random.nextInt(MAX_AGE),
                    random.nextInt(MAX_AGE - MIN_AGE) + MIN_AGE));
        }
        List<String> filteredPeopleSurnames = people.stream().filter(person -> person.getAge() < SELECTED_AGE)
                .peek(System.out::println)
                .sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName))
                .limit(4)
                .map(person -> person.getSurname())
                .collect(Collectors.toList());
        filteredPeopleSurnames.forEach(System.out::println);
    }
}
