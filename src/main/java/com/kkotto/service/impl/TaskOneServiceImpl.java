package com.kkotto.service.impl;

import com.kkotto.service.FileTread;
import com.kkotto.service.FileUtils;
import com.kkotto.service.TaskService;

import java.nio.file.Path;

public class TaskOneServiceImpl implements TaskService {
    private static final int THREADS_QUANTITY = 5;

    @Override
    public void runTask() {
        String directoryForTask = String.format(FileUtils.FILE_PATH_ALL_TASKS, FileUtils.FILE_SEPARATOR);
        FileUtils.createDirectories(Path.of(directoryForTask));
        for (int i = 0; i < THREADS_QUANTITY; i++) {
            new FileTread("Thread " + i).start();
        }
    }
}
