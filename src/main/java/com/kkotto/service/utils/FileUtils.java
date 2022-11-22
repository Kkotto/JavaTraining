package com.kkotto.service.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    static final Logger logger = LogManager.getLogger(FileUtils.class);
    private static FileUtils instance;

    private FileUtils() {
    }

    public static FileUtils getInstance() {
        if (instance == null) {
            instance = new FileUtils();
        }
        return instance;
    }

    public void writeToFile(File file, List<String> list) {
        if (!file.exists()) {
            file = createFile(file.getPath());
        }
        try (FileWriter writer = new FileWriter(file, false)) {
            for (String line : list) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            logger.error("Impossible to write to file " + file.getName());
        }
    }

    public File createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                logger.info(file.getName() + " was successfully created.");
            } else {
                logger.info(file.getName() + " already exists.");
            }
        } catch (IOException e) {
            logger.error("Impossible to create file " + file.getName());
        }
        return file;
    }

    public List<String> readFileByLines(File file) {
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
