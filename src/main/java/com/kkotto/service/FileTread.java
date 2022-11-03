package com.kkotto.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class FileTread extends Thread {
    private final String filePath = "src%1$s%1$smain%1$s%1$sjava%1$s%1$scom%1$s%1$skkotto%1$s%1$s";
    private final String fileExtending = ".txt";
    private final int NUMBERS_QUANTITY = 10;
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 100;

    public FileTread(String threadName) {
        super(threadName);
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        String fileName = filePath + threadName + fileExtending;
        File fileForThread = FileUtils.createFile(String.format(fileName, FileUtils.FILE_SEPARATOR));
        List<Integer> listOfNumbers = ListUtils.createIntegerList(NUMBERS_QUANTITY, MIN_VALUE, MAX_VALUE);
        FileUtils.writeToFile(fileForThread, listOfNumbers);
        String outputString = String.format("%s - %s: %d",
                LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
                threadName,
                ListUtils.findMaxListValue(listOfNumbers));
        System.out.println(outputString);
    }
}
