package com.education.ztu;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        StringMethods.stringOperations("I learn Java!!!");
        StringBuilderMethods.stringBuilderOperations(4, 36);
        Receipt.printReceipt();
        Localization.printLocalizedReceipt(new Locale("ua", "UA"));
        DateTimeOperations.dateOperations();
    }
}
