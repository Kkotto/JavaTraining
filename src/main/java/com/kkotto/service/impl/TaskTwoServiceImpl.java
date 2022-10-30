package com.kkotto.service.impl;

import com.kkotto.service.TaskService;
import com.kkotto.model.FileUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class TaskTwoServiceImpl implements TaskService {
    private final String RESULT_FILE_PATH =
            String.format("src%1$s%1$smain%1$s%1$sjava%1$s%1$scom%1$s%1$skkotto%1$s%1$sTask-2-result.txt", File.separator);
    private final int MIN_WORD_LENGTH = 3;
    private final int MAX_WORD_LENGTH = 5;

    @Override
    public void runTask() {
        String originalFilePath = "Task-2.txt";
        File originalFile = FileUtils.createFile(originalFilePath);
        List<String> textFromFile = FileUtils.readFile(originalFile);
        if (!textFromFile.isEmpty()) {
            textFromFile = deleteWords(textFromFile);
            File resultFile = FileUtils.createFile(RESULT_FILE_PATH);
            FileUtils.writeToFile(resultFile, textFromFile);
        }
    }

    private List<String> deleteWords(List<String> wordsInText) {
        return wordsInText.stream()
                .filter(s -> s.length() < MIN_WORD_LENGTH || s.length() > MAX_WORD_LENGTH)
                .collect(Collectors.toList());
    }
}
