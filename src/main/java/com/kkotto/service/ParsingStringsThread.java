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
        List<String> originalStrings = FileUtils.readFileByLines(
                new File(String.format(
                        FileUtils.FILE_PATH_ALL_TASKS + Thread.currentThread().getName() + FileUtils.FILENAME_EXTENSION,
                        FileUtils.FILE_SEPARATOR)));
        File parsedStringsFile = FileUtils.createFile(String.format(FileUtils.FILE_PATH_ALL_TASKS + RESULT_FILE, FileUtils.FILE_SEPARATOR));
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
