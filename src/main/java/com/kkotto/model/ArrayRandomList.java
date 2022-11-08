package com.kkotto.model;

import com.kkotto.service.ListType;

import java.util.ArrayList;
import java.util.Random;

public class ArrayRandomList extends ListRandom {
    @Override
    public void generateList() {
        Random random = new Random();
        currentList = new ArrayList<>();
        currentListType = ListType.ARRAY_LIST;
        for (int i = 0; i < NUMBERS_QUANTITY; i++) {
            currentList.add(random.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE);
        }
        System.out.println(ListType.ARRAY_LIST + " was generated.");
    }
}
