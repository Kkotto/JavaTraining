package com.kkotto.service.impl;

import com.kkotto.model.FileUtils;
import com.kkotto.service.TaskService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskOneServiceImpl implements TaskService {
    private final String FILE_PATH =
            String.format("src%1$s%1$smain%1$s%1$sjava%1$s%1$scom%1$s%1$skkotto%1$s%1$sTask-1.txt", File.separator);

    @Override
    public void runTask() {
        File originalFile = FileUtils.createFile(FILE_PATH);
        List<Integer> listOfNumbers = createList();
        FileUtils.writeToFile(originalFile, listOfNumbers);
        int sumOfNumbers = countSum(listOfNumbers);
        FileUtils.writeToFile(originalFile, sumOfNumbers);
    }

    private List<Integer> createList() {
        Random random = new Random();
        int maxValue = 100, minValue = 0;
        int numberOfValues = random.nextInt(maxValue - minValue) + minValue;
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfValues; i++) {
            listOfNumbers.add(random.nextInt(maxValue - minValue) + minValue);
        }
        return listOfNumbers;
    }

    private int countSum(List<Integer> listOfNumbers) {
        return listOfNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
