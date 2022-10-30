package com.kkotto.service.impl;

import com.kkotto.service.TaskService;
import com.kkotto.model.FileUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class TaskTwoServiceImpl implements TaskService {
    private final String RESULT_FILE_PATH =
            String.format("src%1$s%1$smain%1$s%1$sjava%1$s%1$scom%1$s%1$skkotto%1$s%1$sTask-2-result.txt", File.separator);
    private final int MIN_LENGTH = 3;
    private final int MAX_LENGTH = 5;

    @Override
    public void runTask() {
        String originalFilePath = "Task-2.txt";
        File collectionFile = FileUtils.createFile(originalFilePath);
        List<String> fileText = FileUtils.readFile(collectionFile);
        if (!fileText.isEmpty()) {
            fileText = deleteWords(fileText);
            File resultFile = FileUtils.createFile(RESULT_FILE_PATH);
            FileUtils.writeToFile(resultFile, fileText);
        }
    }

    private List<String> deleteWords(List<String> words) {
        return words.stream()
                .filter(s -> s.length() < MIN_LENGTH || s.length() > MAX_LENGTH)
                .collect(Collectors.toList());
    }
}
