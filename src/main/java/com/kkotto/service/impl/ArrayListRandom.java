package com.kkotto.service.impl;

import com.kkotto.service.ListRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayListRandom implements ListRandom {
    private static ArrayListRandom instance;
    private static List<Integer> currentListOfNumbers;

    private ArrayListRandom() {
    }

    public static ArrayListRandom getInstance() {
        if (instance == null) {
            instance = new ArrayListRandom();
        }
        return instance;
    }

    @Override
    public void generateList() {
        currentListOfNumbers = new ArrayList<>();
        for (int i = 0; i < ELEMENTS_QUANTITY; i++) {
            currentListOfNumbers.add(new Random().nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE);
        }
    }

    @Override
    public void printList() {
        System.out.println("ArrayList: ");
        currentListOfNumbers.forEach(integer -> System.out.print(integer + " "));
        System.out.println();
    }
}
