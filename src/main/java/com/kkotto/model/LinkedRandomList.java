package com.kkotto.model;

import com.kkotto.service.ListType;

import java.util.LinkedList;
import java.util.Random;

public class LinkedRandomList extends ListRandom {
    @Override
    public void generateList() {
        Random random = new Random();
        currentList = new LinkedList<>();
        currentListType = ListType.LINKED_LIST;
        for (int i = 0; i < NUMBERS_QUANTITY; i++) {
            currentList.add(random.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE);
        }
        System.out.println(ListType.LINKED_LIST + " was generated.");
    }
}
