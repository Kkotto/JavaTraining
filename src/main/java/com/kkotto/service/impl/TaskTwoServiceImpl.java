package com.kkotto.service.impl;

import com.kkotto.service.FileUtils;
import com.kkotto.service.ListUtils;
import com.kkotto.service.ParsingStringsThread;
import com.kkotto.service.TaskService;

import java.io.File;

public class TaskTwoServiceImpl implements TaskService {
    private final int STRINGS_QUANTITY = 10;
    private final String TASK_NAME = "Task2";

    @Override
    public void runTask() {
        File fileForGeneratedStrings = FileUtils.createFile(String.format(
                FileUtils.FILE_PATH_ALL_TASKS + TASK_NAME + FileUtils.FILENAME_EXTENSION,
                FileUtils.FILE_SEPARATOR));
        FileUtils.writeToFileByLines(fileForGeneratedStrings, ListUtils.generateStrings(STRINGS_QUANTITY));
        new ParsingStringsThread(TASK_NAME).start();
    }
}
