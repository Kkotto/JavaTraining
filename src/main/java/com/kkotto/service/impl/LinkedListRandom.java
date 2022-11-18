package com.kkotto.service.impl;

import com.kkotto.service.ListRandom;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LinkedListRandom implements ListRandom {
    private static LinkedListRandom instance;
    private static List<Integer> currentListOfNumbers;

    private LinkedListRandom() {
    }

    public static LinkedListRandom getInstance() {
        if (instance == null) {
            instance = new LinkedListRandom();
        }
        return instance;
    }

    @Override
    public void generateList() {
        currentListOfNumbers = new LinkedList<>();
        for (int i = 0; i < ELEMENTS_QUANTITY; i++) {
            currentListOfNumbers.add(new Random().nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE);
        }
    }

    @Override
    public void printList() {
        System.out.println("LinkedList: ");
        currentListOfNumbers.forEach(integer -> System.out.print(integer + " "));
        System.out.println();
    }
}
