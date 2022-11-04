package com.kkotto.service;

public class SyncThreads extends Thread {
    public SyncThreads(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        new SyncTesting().checkStats();
    }
}
