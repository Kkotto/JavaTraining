package com.kkotto;

import com.kkotto.service.TaskService;
import com.kkotto.service.impl.TaskOneServiceImpl;
import com.kkotto.service.impl.TaskTwoServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskService taskOne = new TaskOneServiceImpl();
        TaskService taskTwo = new TaskTwoServiceImpl();
        List<TaskService> tasks = List.of(taskOne, taskTwo);
        tasks.forEach(TaskService::runTask);
    }
}
