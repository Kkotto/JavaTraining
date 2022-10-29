package com.kkotto;

import com.kkotto.service.impl.TaskOneServiceImpl;
import com.kkotto.service.impl.TaskTwoServiceImpl;

public class Main {
    public static void main(String[] args) {
        //new TaskOneServiceImpl().runTask();
        new TaskTwoServiceImpl().runTask();
    }
}
