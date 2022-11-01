package com.kkotto.service.impl;

import com.kkotto.service.TaskService;
import com.kkotto.service.FileUtils;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class TaskTwoServiceImpl implements TaskService {
    private final String RESULT_FILE_PATH =
            "src%1$s%1$smain%1$s%1$sjava%1$s%1$scom%1$s%1$skkotto%1$s%1$sTask-2-result.txt";
    private final String ORIGINAL_FILE_PATH = "Task-2.txt";
    private final int MIN_WORD_LENGTH = 3;
    private final int MAX_WORD_LENGTH = 5;

    @Override
    public void runTask() {
        File originalFile = FileUtils.createFile(ORIGINAL_FILE_PATH);
        List<String> textFromFile = FileUtils.readFileByWords(originalFile);
        if (!textFromFile.isEmpty()) {
            textFromFile = deleteWords(textFromFile);
            File resultFile = FileUtils.createFile(String.format(RESULT_FILE_PATH, FileUtils.FILE_SEPARATOR));
            FileUtils.writeToFile(resultFile, textFromFile);
        }
    }

    private List<String> deleteWords(List<String> wordsInText) {
        return wordsInText.stream()
                .filter(s -> s.length() < MIN_WORD_LENGTH || s.length() > MAX_WORD_LENGTH)
                .collect(Collectors.toList());
    }
}
