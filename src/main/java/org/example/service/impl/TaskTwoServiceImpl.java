package org.example.service.impl;

import org.example.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TaskTwoServiceImpl implements TaskService {
    private final Scanner SCANNER = new Scanner(System.in);
    private final int FIRST_DIVIDER = 3;
    private final int SECOND_DIVIDER = 5;

    @Override
    public void runTask() {
        Random random = new Random();

        int n = scanNumber("N");
        int minValue = scanNumber("Min value");
        int maxValue = scanNumber("Max value");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(maxValue - minValue) + minValue);
        }
        System.out.printf("\nNumbers divisible by %d and %d at the same time without a reminder are "
                + (list.stream().peek(number -> System.out.print(number + " "))
                .anyMatch(number -> number % FIRST_DIVIDER == 0 && number % SECOND_DIVIDER == 0) ? "" : "not ")
                + "contained in the list.", FIRST_DIVIDER, SECOND_DIVIDER);

        SCANNER.close();
    }

    public int scanNumber(String variableName) {
        System.out.print(variableName + " = ");
        return SCANNER.nextInt();
    }
}
