package com.kkotto.model;

import com.kkotto.service.ListType;

public class ListFactory {
    public ListRandom createCollection(ListType listType) {
        if (listType != null) {
            //Стоит ли использовать Java 12 switch с case ARRAY_LIST ->
            switch (listType) {
                case ARRAY_LIST:
                    return new ArrayRandomList();
                case LINKED_LIST:
                    return new LinkedRandomList();
                default:
                    throw new IllegalArgumentException("Unknown type: " + listType);
            }
        } else {
            throw new NullPointerException("Null value");
        }

    }
}
