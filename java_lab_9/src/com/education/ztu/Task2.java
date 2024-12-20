package com.education.ztu;

import java.util.regex.*;

public class Task2 {
    public static void run() {
        String text = """
            Гоша Іваненко, 30 років, розробник, email: gosha.ivanenko@example.com, телефон: +38093658565, дата: 21.01.1994
            Юля Стенаненко, 52 років, дизайнер, email: yulia.stepanenko@example.com, телефон: +380730274020, дата: 20.09.1988
            """;

        System.out.println("Оригінальний текст:");
        System.out.println(text);


        System.out.println("\nНомери телефонів:");
        Pattern phonePattern = Pattern.compile("\\+380\\d{9}");
        Matcher phoneMatcher = phonePattern.matcher(text);
        while (phoneMatcher.find()) {
            System.out.println(phoneMatcher.group());
        }


        System.out.println("\nEmail адреси:");
        Pattern emailPattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");
        Matcher emailMatcher = emailPattern.matcher(text);
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }


        String updatedText = text.replaceAll("(\\d{2})\\.(\\d{2})\\.(\\d{4})", "$3-$2-$1");
        System.out.println("\nТекст з оновленими датами:");
        System.out.println(updatedText);


        String updatedRoles = updatedText.replaceAll("розробник", "тестувальник")
                .replaceAll("дизайнер", "аналітик");
        System.out.println("\nТекст з оновленими посадами:");
        System.out.println(updatedRoles);
    }
}
