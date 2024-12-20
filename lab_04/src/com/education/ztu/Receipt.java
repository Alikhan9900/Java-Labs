package com.education.ztu;

import java.util.Formatter;

public class Receipt {

    public static void printReceipt() {
        Formatter formatter = new Formatter();
        System.out.println("Дата та час покупки: 28.03.2019 13:25:12");
        System.out.println("===========================================");
        System.out.println("№    Товар        Категорія      Ціна");
        System.out.println("===========================================");
        formatter.format("%d.   %-10s  %-15s %.2f ₴\n", 1, "Джинси", "Жіночий одяг", 1500.78);
        formatter.format("%d.   %-10s  %-15s %.2f ₴\n", 2, "Спідниця", "Жіночий одяг", 1000.56);
        formatter.format("%d.   %-10s  %-15s %.2f ₴\n", 3, "Краватка", "Чоловічий одяг", 500.78);
        System.out.println(formatter);
        System.out.println("===========================================");
        System.out.println("Разом: 3002,34 ₴");
    }
}