package com.kkotto;

import com.kkotto.service.TaskService;
import com.kkotto.service.impl.TaskOneServiceImpl;
import com.kkotto.service.impl.TaskThreeServiceImpl;
import com.kkotto.service.impl.TaskTwoServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TaskService> listOfTasks = new ArrayList<>();
        listOfTasks.add(new TaskOneServiceImpl());
        listOfTasks.add(new TaskTwoServiceImpl());
        listOfTasks.add(new TaskThreeServiceImpl());
        listOfTasks.forEach(TaskService::runTask);
    }
}
