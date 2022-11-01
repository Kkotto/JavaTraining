package com.kkotto.service.impl;

import com.kkotto.model.Product;
import com.kkotto.service.FileUtils;
import com.kkotto.service.TaskService;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskThreeServiceImpl implements TaskService {
    private final String STORAGE_FILE_PATH = "src%1$s%1$smain%1$s%1$sjava%1$s%1$scom%1$s%1$skkotto%1$s%1$s" +
            "storage%1$s%1$sprice%1$s%1$slist%1$s%1$s";
    private final String FILE_NAME = "Task-3.txt";
    private final String FILE_CONTENT = """
            Name;UniqueNumber;Price;Count;Production
            Windows 10;00001;2000;20;Microsoft
            USB Flash Drive;20021;500;100;Samsung
            Dell x-01;200232;1000;Notebook Dell;10;Dell
            Dell od-1;3449;700;Monitor Dell;15;Dell
            Asus x50m;4290;500;Notebook Asus;3;Asus""";

    @Override
    public void runTask() {
        String formattedFilePath = String.format(STORAGE_FILE_PATH, FileUtils.FILE_SEPARATOR);
        FileUtils.createDirectories(Path.of(formattedFilePath));
        File storageFile = FileUtils.createFile(formattedFilePath + FILE_NAME);
        FileUtils.writeToFile(storageFile, FILE_CONTENT);
        List<String> textLines = FileUtils.readFileByLines(storageFile);
        textLines = deleteLines(textLines);
        List<Product> productList = createProducts(textLines);
    }

    public List<String> deleteLines(List<String> textLines) {
        return textLines.stream()
                .filter(s -> s.matches(".*\\d+.*"))
                .collect(Collectors.toList());
    }

    public List<Product> createProducts(List<String> textLines) {
        int recordsNumber = textLines.size();
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < recordsNumber; i++) {
            productList.add(new Product());
        }
        return productList;
    }

    public void fillProducts(List<Product> productList, List<String> textLines) {
        for (int i = 0; i < textLines.size(); i++) {
            String line = textLines.get(i);
            String[] params = line.split(";");

        }
    }
}
