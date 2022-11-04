package com.kkotto;

import com.kkotto.service.TaskService;
import com.kkotto.service.impl.TaskOneServiceImpl;
import com.kkotto.service.impl.TaskThreeServiceImpl;
import com.kkotto.service.impl.TaskTwoServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskService firstTask = new TaskOneServiceImpl();
        TaskService secondTask = new TaskTwoServiceImpl();
        TaskService thirdTask = new TaskThreeServiceImpl();
        List<TaskService> taskServiceList = new ArrayList<>();
        taskServiceList.add(firstTask);
        taskServiceList.add(secondTask);
        taskServiceList.add(thirdTask);
        taskServiceList.forEach(TaskService::runTask);
    }
}