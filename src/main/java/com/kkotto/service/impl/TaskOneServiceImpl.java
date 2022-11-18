package com.kkotto.service.impl;

import com.kkotto.service.ListFactory;
import com.kkotto.service.ListRandom;
import com.kkotto.service.ListType;
import com.kkotto.service.TaskService;

import java.util.ArrayList;
import java.util.List;

public class TaskOneServiceImpl implements TaskService {
    private static TaskOneServiceImpl instance;

    private TaskOneServiceImpl() {
    }

    public static TaskOneServiceImpl getInstance() {
        if (instance == null) {
            instance = new TaskOneServiceImpl();
        }
        return instance;
    }

    @Override
    public void runTask() {
        ListFactory listFactory = new ListFactory();
        List<ListRandom> listOfRandomLists = new ArrayList<>();
        ListRandom arrayListSingleton = listFactory.createCollection(ListType.ARRAY_LIST);
        ListRandom linkedListSingleton = listFactory.createCollection(ListType.LINKED_LIST);
        listOfRandomLists.add(arrayListSingleton);
        listOfRandomLists.add(linkedListSingleton);
        listOfRandomLists.forEach(ListRandom::generateList);
        listOfRandomLists.forEach(ListRandom::printList);
    }
}
