package com.kkotto.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SyncTesting {
    public synchronized void checkStats() {
        System.out.printf("%s: %s\n", Thread.currentThread().getName(), LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
        try {
            System.out.println(Thread.currentThread().getName() + " now sleeping");
            Thread.sleep(5000);
            //Как-то не заметно, что пауза работает.
            //Я ожидала "поток 1: время" - "поток 1 спит" - "поток х: время" - "поток х спит",
            //но, видимо, вот:
            /*
            Thread 7: 20:34:14.2993266
            Thread 9: 20:34:14.2983471
            Thread 6: 20:34:14.2984907
            Thread 4: 20:34:14.2993266
            Thread 8: 20:34:14.2965995
            Thread 8 now sleeping
            Thread 5: 20:34:14.2993266
            Thread 1: 20:34:14.2984907
            Thread 3: 20:34:14.2975967
            Thread 2: 20:34:14.2983471
            Thread 0: 20:34:14.2993266
            Thread 2 now sleeping
            Thread 3 now sleeping
            Thread 1 now sleeping
            Thread 5 now sleeping
            Thread 4 now sleeping
            Thread 6 now sleeping
            Thread 7 now sleeping
            Thread 9 now sleeping
            Thread 0 now sleeping
            */
            //Так и должно быть?
            //А, ну он делает паузу после вывода всех заданий, но либо я неправильно поняла synchronized,
            //либо неправильно использовала, либо что-то пошло не так?
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
