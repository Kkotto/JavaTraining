package com.kkotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListUtils {
    public static List<Integer> createIntegerList(int numbersQuantity, int minValue, int maxValue) {
        Random random = new Random();
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < numbersQuantity; i++) {
            listOfNumbers.add(random.nextInt(maxValue - minValue) + minValue);
        }
        return listOfNumbers;
    }

    public static int findMaxListValue(List<Integer> listOfNumbers) {
        return listOfNumbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }
}
