package com.education.ztu;

public class StringMethods {
    public static void stringOperations(String input) {
        System.out.println("Останній символ: " + input.charAt(input.length() - 1));
        System.out.println("Закінчується на '!!!': " + input.endsWith("!!!"));
        System.out.println("Починається на 'I learn ': " + input.startsWith("I learn "));
        System.out.println("Містить 'Java': " + input.contains("Java"));
        System.out.println("Позиція 'Java': " + input.indexOf("Java"));
        System.out.println("Замінено 'а' на 'о': " + input.replace('a', 'o'));
        System.out.println("Верхній регістр: " + input.toUpperCase());
        System.out.println("Нижній регістр: " + input.toLowerCase());
        System.out.println("Вирізати 'Java': " + input.substring(input.indexOf("Java"), input.indexOf("Java") + 4));
    }
}
