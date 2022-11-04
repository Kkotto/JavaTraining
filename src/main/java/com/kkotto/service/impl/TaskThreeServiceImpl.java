package com.kkotto.service.impl;

import com.kkotto.service.SyncThreads;
import com.kkotto.service.TaskService;

public class TaskThreeServiceImpl implements TaskService {
    private final int THREADS_QUANTITY = 10;

    @Override
    public void runTask() {
        for (int i = 0; i < THREADS_QUANTITY; i++) {
            new SyncThreads("Thread " + i).start();
        }
    }
}
