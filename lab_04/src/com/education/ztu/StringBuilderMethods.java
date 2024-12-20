package com.education.ztu;

public class StringBuilderMethods {
    public static void stringBuilderOperations(int a, int b) {
        StringBuilder sb = new StringBuilder();

        sb.append(a).append(" + ").append(b).append(" = ").append(a + b);
        System.out.println(sb);

        sb.setLength(0);
        sb.append(a).append(" - ").append(b).append(" = ").append(a - b);
        System.out.println(sb);

        sb.setLength(0);
        sb.append(a).append(" * ").append(b).append(" = ").append(a * b);
        System.out.println(sb);

        sb.replace(sb.indexOf("="), sb.indexOf("=") + 1, "рівно");
        System.out.println(sb);

        sb.reverse();
        System.out.println("Реверс: " + sb);
        System.out.println("Довжина: " + sb.length() + ", capacity: " + sb.capacity());
    }
}
