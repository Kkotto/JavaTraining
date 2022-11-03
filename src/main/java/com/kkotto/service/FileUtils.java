package com.kkotto.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    public static final String FILE_SEPARATOR = File.separator;

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
}
