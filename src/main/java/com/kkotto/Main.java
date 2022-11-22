package com.kkotto;

import com.kkotto.service.impl.TaskServiceImpl;

public class Main {
    public static void main(String[] args) {
        TaskServiceImpl.getInstance().runTask();
    }
}
