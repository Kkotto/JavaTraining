package com.kkotto.service.impl;

import com.kkotto.service.FileTread;
import com.kkotto.service.TaskService;

public class TaskOneServiceImpl implements TaskService {
    private static final int THREADS_QUANTITY = 5;

    @Override
    public void runTask() {
        for (int i = 0; i < THREADS_QUANTITY; i++) {
            new FileTread("Thread " + i).start();
        }
    }
}
