package com.kkotto.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static final String FILE_SEPARATOR = File.separator;
    public static final String FILE_PATH_ALL_TASKS = "src%1$s%1$smain%1$s%1$sjava%1$s%1$scom%1$s%1$skkotto%1$s%1$staskFiles%1$s%1$s";
    public static final String FILENAME_EXTENSION = ".txt";

    public static File createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println(file.getName() + " was successfully created.");
            } else {
                System.out.println(file.getName() + " already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return file;
    }

    public static void writeToFile(File file, List<?> list) {
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(list.toString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void writeToFileByLines(File file, List<String> list) {
        try (FileWriter writer = new FileWriter(file, false)) {
            for (String string : list) {
                writer.write(string + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static List<String> readFileByLines(File file) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return lines;
    }
}
