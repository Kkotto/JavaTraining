package com.kkotto.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class DateTimeUtils {
    public static int generateYear() {
        int minYear = 2000, maxYear = 2022;
        Random random = new Random();
        return random.nextInt(maxYear - minYear + 1) + minYear;
    }

    public static int generateMonth() {
        int minMonth = 0, maxMonth = 11;
        Random random = new Random();
        return random.nextInt(maxMonth - minMonth + 1) + minMonth;
    }

    public static int generateDay(int month, boolean isLeapYear) {
        Random random = new Random();
        int minDay = 1;
        int maxDay = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear ? 29 : 28;
            default -> throw new IndexOutOfBoundsException(month + " number is not valid.");
        };
        return random.nextInt(maxDay - minDay + 1) + minDay;
    }

    public static boolean isYearLeap(int year) {
        return year % 4 == 0 || year % 400 == 0;
    }

    public static int generateHour() {
        Random random = new Random();
        int minHour = 0, maxHour = 23;
        return random.nextInt(maxHour - minHour + 1) + minHour;
    }

    public static int generateMinutes() {
        Random random = new Random();
        int minMinute = 0, maxMinute = 59;
        return random.nextInt(maxMinute - minMinute + 1) + minMinute;
    }

    public static int generateHourLength() {
        Random random = new Random();
        int minHoursLength = 1, maxHoursLength = 500;
        return random.nextInt(maxHoursLength - minHoursLength + 1) + minHoursLength;
    }

    public static Calendar createCalendar(int year, int month, int day, int hour, int minute){
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        return calendar;
    }
}
