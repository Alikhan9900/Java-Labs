package com.education.ztu;

import java.lang.reflect.*;

public class Task3 {
    public static void run() {
        try {
            Class<?> clazz = Employee.class;


            System.out.println("Поля класу:");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println(field.getName() + " : " + field.getType());
            }


            System.out.println("\nМетоди класу:");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method.getName());
            }


            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            Object employee = constructor.newInstance("Gosha Yra", 35);


            Method displayMethod = clazz.getMethod("displayInfo");
            displayMethod.invoke(employee);


            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(employee, 40);

            System.out.println("\nПісля зміни приватного поля:");
            displayMethod.invoke(employee);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
