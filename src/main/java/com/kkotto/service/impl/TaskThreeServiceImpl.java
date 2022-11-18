package com.kkotto.service.impl;

import com.kkotto.service.DateTimeUtils;
import com.kkotto.service.TaskService;

import java.util.Calendar;
import java.util.Locale;

public class TaskThreeServiceImpl implements TaskService {
    private static TaskThreeServiceImpl instance;

    private TaskThreeServiceImpl() {

    }

    public static TaskThreeServiceImpl getInstance() {
        if (instance == null) {
            instance = new TaskThreeServiceImpl();
        }
        return instance;
    }

    @Override
    public void runTask() {
        int generatedYear = DateTimeUtils.generateYear();
        int generatedMonth = DateTimeUtils.generateMonth();
        int generatedDay = DateTimeUtils.generateDay(generatedMonth, DateTimeUtils.isYearLeap(generatedYear));
        int generatedHour = DateTimeUtils.generateHour();
        int generatedMinute = DateTimeUtils.generateMinutes();
        int tripLengths = DateTimeUtils.generateHourLength();
        System.out.println("Trip length: " + tripLengths + " hours");
        Calendar calendar = DateTimeUtils.createCalendar(generatedYear, generatedMonth, generatedDay, generatedHour, generatedMinute);
        System.out.println("Trip started: " + calendar.getTime());
        calendar.add(Calendar.HOUR, tripLengths);
        System.out.println("Trip finished: " + calendar.getTime());
        System.out.println("Trip ended on " + calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
    }
}
