package com.education.ztu;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateTimeOperations {

    public static void dateOperations() {
        LocalDateTime labStart = LocalDateTime.of(2024, 12, 17, 10, 0, 0);
        System.out.println("День тижня: " + labStart.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.UK));
        System.out.println("День року: " + labStart.getDayOfYear());
        System.out.println("Місяць: " + labStart.getMonth().getDisplayName(TextStyle.FULL, Locale.UK));
        System.out.println("Рік: " + labStart.getYear());
        System.out.println("Час: " + labStart.toLocalTime());

        boolean isLeapYear = labStart.toLocalDate().isLeapYear();
        System.out.println("Рік високосний: " + isLeapYear);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("Поточний час після початку лабораторної: " + now.isAfter(labStart));
        System.out.println("Поточний час до початку лабораторної: " + now.isBefore(labStart));

        LocalDateTime modified = labStart.plusDays(5).plusHours(3);
        System.out.println("Змінена дата і час: " + modified);
    }
}