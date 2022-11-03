package com.kkotto;

import com.kkotto.service.TaskService;
import com.kkotto.service.impl.TaskOneServiceImpl;
import com.kkotto.service.impl.TaskTwoServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskService firstTask = new TaskOneServiceImpl();
        TaskService secondTask = new TaskTwoServiceImpl();
        List<TaskService> taskServiceList = new ArrayList<>();
        taskServiceList.add(firstTask);
        taskServiceList.add(secondTask);
        taskServiceList.forEach(TaskService::runTask);
    }
}