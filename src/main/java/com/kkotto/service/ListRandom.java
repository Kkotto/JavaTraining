package com.kkotto.service;

public interface ListRandom {
    int ELEMENTS_QUANTITY = 50;
    int MIN_VALUE = 0;
    int MAX_VALUE = 20;

    void generateList();

    void printList();
}
