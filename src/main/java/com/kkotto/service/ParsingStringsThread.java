package com.kkotto.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ParsingStringsThread extends Thread {
    private final String RESULT_FILE = "Result.txt";

    public ParsingStringsThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        String threadFileName = FileUtils.FILE_PATH_ALL_TASKS + threadName + FileUtils.FILENAME_EXTENSION;
        List<String> originalStrings = FileUtils.readFileByLines(new File(String.format(threadFileName, FileUtils.FILE_SEPARATOR)));
        String resultFileName = FileUtils.FILE_PATH_ALL_TASKS + RESULT_FILE;
        File parsedStringsFile = FileUtils.createFile(String.format(resultFileName, FileUtils.FILE_SEPARATOR));
        FileUtils.writeToFileByLines(parsedStringsFile, parseStrings(originalStrings));
        System.out.printf("Result file size (Task 2): %s bytes\n", parsedStringsFile.length());
    }

    private List<String> parseStrings(List<String> originalStrings) {
        List<String> parsedStrings = new ArrayList<>();
        for (String string : originalStrings) {
            if (!string.substring(string.lastIndexOf("\\")).contains(".txt")) {
                parsedStrings.add(string);
            }
        }
        return parsedStrings;
    }
}
