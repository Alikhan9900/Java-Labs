package com.education.ztu;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class Task4 {
    public static void run() {
        Class<?> clazz = AnnotatedClass.class;

        if (clazz.isAnnotationPresent(Info.class)) {
            Info info = clazz.getAnnotation(Info.class);
            System.out.println("Дані анотації:");
            System.out.println("Автор: " + info.author());
            System.out.println("Дата: " + info.date());
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Info {
    String author() default "Unknown";
    String date();
}

@Info(author = "Student", date = "2024-06-10")
class AnnotatedClass {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}
