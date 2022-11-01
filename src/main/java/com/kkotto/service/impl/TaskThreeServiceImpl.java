package com.kkotto.service.impl;

import com.kkotto.model.Product;
import com.kkotto.service.FileUtils;
import com.kkotto.service.TaskService;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskThreeServiceImpl implements TaskService {
    private final String STORAGE_FILE_PATH = "src%1$s%1$smain%1$s%1$sjava%1$s%1$scom%1$s%1$skkotto%1$s%1$sstorage%1$s%1$sprice%1$s%1$slist%1$s%1$s";
    private final String FILE_NAME = "Task-3.txt";
    private final String FILE_CONTENT = """
            Name;UniqueNumber;Price;Count;Production
            Windows 10;00001;2000;20;Microsoft
            USB Flash Drive;20021;500;100;Samsung
            Dell x-01;200232;1000;Notebook Dell;10;Dell
            Dell od-1;3449;700;Monitor Dell;15;Dell
            Asus x50m;4290;500;Notebook Asus;3;Asus""";
    private final String REGEX_PARAMS_SEPARATOR = ";";

    @Override
    public void runTask() {
        String formattedFilePath = String.format(STORAGE_FILE_PATH, FileUtils.FILE_SEPARATOR);
        FileUtils.createDirectories(Path.of(formattedFilePath));
        File storageFile = FileUtils.createFile(formattedFilePath + FILE_NAME);
        FileUtils.writeToFile(storageFile, FILE_CONTENT);
        List<String> textLines = FileUtils.readFileByLines(storageFile);
        List<Product> productList = createProducts(textLines);
        System.out.println("Product with the lowest price: " + productList.get(findMinPriceIndex(productList, findMinPriceValue(productList))));
    }

    public List<Product> createProducts(List<String> textLines) {
        List<Product> productList = new ArrayList<>();
        for (String textLine : textLines) {
            String[] params = textLine.split(REGEX_PARAMS_SEPARATOR);
            Product tempProduct = new Product();
            try {
                tempProduct.setName(params[0]);
                tempProduct.setUniqueNumber(params[1]);
                tempProduct.setPrice(Integer.parseInt(params[2]));
                tempProduct.setCount(Integer.parseInt(params[3]));
                tempProduct.setProduction(params[4]);
                productList.add(tempProduct);
                System.out.println("Successfully added record: " + textLine);
            } catch (NumberFormatException e) {
                System.out.println("Not valid record: " + textLine);
            }
        }
        return productList;
    }

    public int findMinPriceValue(List<Product> productList) {
        return productList.stream()
                .map(Product::getPrice)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public int findMinPriceIndex(List<Product> productList, int minPrice) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() == minPrice) {
                return i;
            }
        }
        return 0;
    }
}
