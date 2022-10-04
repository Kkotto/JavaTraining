package org.example.service.impl;

import org.example.service.TaskService;

import java.util.*;

public class TaskOneServiceImpl implements TaskService {
    private final int NUMBER_QUANTITY = 50;
    private final int MAX_VALUE = 20;
    private final int MIN_MATCH = 1;

    @Override
    public void runTask() {
        List<Integer> list = createList();
        printList(list);
        Map<Integer, Integer> map = createMap(list);
        printMap(map);
    }

    public void printMap(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            System.out.println("Number " + item.getKey() + " occurs " + item.getValue() + " times.");
        }
    }

    public Map<Integer, Integer> createMap(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        list.forEach(number -> map.put(number, map.containsKey(number) ? map.get(number) + MIN_MATCH : MIN_MATCH));
        return map;
    }

    public List<Integer> createList() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < NUMBER_QUANTITY; i++) {
            list.add(i, random.nextInt(MAX_VALUE));
        }
        return list;
    }

    public void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
