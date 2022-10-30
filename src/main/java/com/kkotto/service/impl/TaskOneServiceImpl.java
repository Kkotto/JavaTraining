package com.kkotto.service.impl;

import com.kkotto.model.FileUtils;
import com.kkotto.service.TaskService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskOneServiceImpl implements TaskService {
    private final String FILE_PATH = "src%1$s%1$smain%1$s%1$sjava%1$s%1$scom%1$s%1$skkotto%1$s%1$sTask-1.txt";
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 100;

    @Override
    public void runTask() {
        File originalFile = FileUtils.createFile(String.format(FILE_PATH, FileUtils.FILE_SEPARATOR));
        List<Integer> listOfNumbers = createList();
        FileUtils.writeToFile(originalFile, listOfNumbers);
        int sumOfNumbers = countSum(listOfNumbers);
        FileUtils.writeToFile(originalFile, sumOfNumbers);
    }

    private List<Integer> createList() {
        Random random = new Random();
        int numberOfValues = random.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
        List<Integer> listOfNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfValues; i++) {
            listOfNumbers.add(random.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE);
        }
        return listOfNumbers;
    }

    private int countSum(List<Integer> listOfNumbers) {
        return listOfNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
