package com.kkotto.service.impl;

import com.kkotto.service.TaskService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskOneServiceImpl implements TaskService {
    private final String FILE_NAME = "Homework-4-task-1.txt";
    private final String FILE_PATH = "src\\main\\java\\com\\kkotto\\" + FILE_NAME;
    //Как правильно прописывать имя, путь и т.д.? Меня смущает существование File.pathSeparator,
    // т.к. в разных системах разные сепараторы, что есть главная фишка Java - запуск везде,
    //но добавление константы с File.pathSeparator, по моему мнению, очень усложнило чтение.
    private final int MAX_VALUE = 100;
    private final int MIN_VALUE = 0;
    private final Random RANDOM = new Random();
    //Можно ли создавать Random, Scanner etc как глобальные переменные?
    //Или, например, они передаются как аргументы метода?
    private final int NUMBER_OF_VALUES = RANDOM.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
    //Так можно? Или лучше инициализировать в теле метода? Теоретически, значение не изменяется и создается в самом начале,
    //так что, по идее, приемлемо.

    @Override
    public void runTask() {
        File file = createFile();
        List<Integer> list = createList();
        writeToFile(file, list);
        System.out.println(list);
        int sum = countSum(list);
        System.out.println(sum);
        writeToFile(file, sum);
    }

    private File createFile() {
        File file = new File(FILE_PATH);
        try {
            if (file.createNewFile()) {
                System.out.println(FILE_NAME + " was successfully created.");
            } else {
                System.out.println(FILE_NAME + " already exists.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    private List<Integer> createList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_VALUES; i++) {
            list.add(RANDOM.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE);
        }
        return list;
    }

    private void writeToFile(File file, List<Integer> list) {
        try {
            Files.writeString(file.toPath(), list.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Тут есть как минимум 4 способа записи?
        //BufferedWriter, PrintWriter, FileOutputStream, а w3school предложил через FileWriter.
        //Такая же штука была со сканером Scanner(System.in), я видела, там через буферное нечто тоже используется.
        //Как я поняла, Files - это новая крутая фича Java 7.

        //(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("filename.txt"), "utf-8")))
        //PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
        //Files.write(file, lines, StandardCharsets.UTF_8);
    }

    private void writeToFile(File file, int number) {
        try {
            Files.writeString(file.toPath(), String.valueOf(number));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Кстати, как люди обрабатывают исключения? Через добавление в сигнатуру и обработку при вызове или в трай кэтч?
        //Учитывая, что ты говорила много про разбиение на мелкие методы, то, разумнее, в трай кэтч,
        //но, на всякий случай, уточняю.
    }

    private int countSum(List<Integer> list) {
        return list
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        //Сам .stream() тоже переносится или остается на строке с листом?
    }
}
