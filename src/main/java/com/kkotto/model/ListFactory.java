package com.kkotto.model;

import com.kkotto.service.ListType;

public class ListFactory {
    public ListRandom createCollection(ListType listType) {
        if (listType != null) {
            return switch (listType) {
                case ARRAY_LIST -> new ArrayRandomList();
                case LINKED_LIST -> new LinkedRandomList();
            };
        } else {
            throw new IllegalStateException("Null value");
        }
    }
}
