package com.kkotto;

import com.kkotto.service.TaskService;
import com.kkotto.service.impl.TaskOneServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskService firstTask = new TaskOneServiceImpl();
        List<TaskService> taskServiceList = new ArrayList<>();
        taskServiceList.add(firstTask);
        taskServiceList.forEach(TaskService::runTask);
    }
}