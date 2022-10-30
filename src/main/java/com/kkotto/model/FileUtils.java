package com.kkotto.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    public static File createFile(String filePath) {
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

    public static List<String> readFile(File file) {
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

    public static void writeToFile(File file, List<?> list) {
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(list.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(File file, int number) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("\nSumma: " + number);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
