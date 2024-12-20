package com.education.ztu;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {

    public static void printLocalizedReceipt(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("resources/data", locale);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        System.out.println(bundle.getString("receipt.date"));
        System.out.println(bundle.getString("receipt.header"));
        System.out.printf(bundle.getString("receipt.item"), 1, "Джинси", "Жіночий одяг", currencyFormat.format(1500.78));
        System.out.println(bundle.getString("receipt.footer"));
    }
}
