package com.kkotto.service.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    static final Logger logger = LogManager.getLogger(FileUtils.class);

    public static List<String> readFileByLines(File file) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found: " + file.getName());
        }
        return lines;
    }
}
