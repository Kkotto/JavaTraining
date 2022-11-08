package com.kkotto.model;

import com.kkotto.service.ListType;

import java.util.List;

public abstract class ListRandom {
    protected final int NUMBERS_QUANTITY = 50;
    protected final int MIN_VALUE = 0;
    protected final int MAX_VALUE = 20;
    protected List<Integer> currentList;
    protected ListType currentListType;

    public abstract void generateList();

    public void printList() {
        System.out.print(currentListType + ": ");
        currentList.forEach(integer -> System.out.print(integer + " "));
        System.out.println();
    }
}
