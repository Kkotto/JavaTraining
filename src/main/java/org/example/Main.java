package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int PEOPLE_AMOUNT=20;
    private static final int AGE_BOUND=15;

    public static void main(String[] args) {
        Random random = new Random();
        List<Person> people = new ArrayList<>();
        for(int i=0; i< PEOPLE_AMOUNT; i++){
            people.add(new Person("Name"+i, "Surname"+i, random.nextInt(AGE_BOUND)+AGE_BOUND));
        }
        for (Person person : people){
            if(person.getAge()>=person.ADULT_AGE){
                System.out.print("Adult: ");
            } else {
                System.out.print("Infant: ");
            }
            System.out.println(person.getName()+" "+person.getSurname()+" - "+person.getAge()+" yo");
        }
    }
}
