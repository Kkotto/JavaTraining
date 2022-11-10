package com.kkotto.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SyncTesting {
    public synchronized void checkStats() {
        System.out.printf("%s: %s\n", Thread.currentThread().getName(), LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
        try {
            System.out.println(Thread.currentThread().getName() + " now sleeping");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
