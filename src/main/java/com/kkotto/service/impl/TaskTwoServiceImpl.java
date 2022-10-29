package com.kkotto.service.impl;

import com.kkotto.service.TaskService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaskTwoServiceImpl implements TaskService {
    private final String RESULT_FILE_NAME = "Task-2-result.txt";
    private final String RESULT_FILE_PATH = "src\\main\\java\\com\\kkotto\\" + RESULT_FILE_NAME;
    private final String ORIGINAL_FILE_NAME = "Task-2.txt";
    private final String ORIGINAL_FILE_PATH = ORIGINAL_FILE_NAME;
    private final int MIN_LENGTH = 3;
    private final int MAX_LENGTH = 5;

    @Override
    public void runTask() {
        File file = createFile(ORIGINAL_FILE_PATH);
        List<String> text = readFile(file);
        if (!text.isEmpty()) {
            List<String> words = deleteWords(text);
            File resultFile = createFile(RESULT_FILE_PATH);
            writeToFile(resultFile, words);
        }
    }

    private File createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println(file.getName() + " was successfully created.");
            } else {
                System.out.println(file.getName() + " already exists.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    private List<String> readFile(File file) {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    private void writeToFile(File file, List<String> list) {
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(list.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> deleteWords(List<String> words) {
        return words
                .stream()
                .filter(s -> s.length() < MIN_LENGTH || s.length() > MAX_LENGTH)
                .collect(Collectors.toList());
    }
}
