package org.example;

import org.example.service.impl.TaskOneServiceImpl;
import org.example.service.impl.TaskTwoServiceImpl;

public class Main {
    public static void main(String[] args) {
        new TaskTwoServiceImpl().runTask();
    }
}
