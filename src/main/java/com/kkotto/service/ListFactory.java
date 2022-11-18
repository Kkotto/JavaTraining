package com.kkotto.service;

import com.kkotto.service.impl.ArrayListRandom;
import com.kkotto.service.impl.LinkedListRandom;

public class ListFactory {
    public ListRandom createCollection(ListType listType) {
        if (listType != null) {
            return switch (listType) {
                case ARRAY_LIST -> ArrayListRandom.getInstance();
                case LINKED_LIST -> LinkedListRandom.getInstance();
            };
        } else {
            throw new IllegalStateException("Null value");
        }
    }
}
