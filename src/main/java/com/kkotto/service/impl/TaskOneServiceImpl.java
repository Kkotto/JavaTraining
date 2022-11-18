package com.kkotto.service.impl;

import com.kkotto.model.ListRandom;
import com.kkotto.model.ListFactory;
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
        ListRandom arrayList = listFactory.createCollection(ListType.ARRAY_LIST);
        ListRandom linkedList = listFactory.createCollection(ListType.LINKED_LIST);
        List<ListRandom> listOfLists = new ArrayList<>();
        listOfLists.add(arrayList);
        listOfLists.add(linkedList);
        listOfLists.forEach(ListRandom::generateList);
        listOfLists.forEach(ListRandom::printList);
    }
}
