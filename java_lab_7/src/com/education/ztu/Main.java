package com.education.ztu;

public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread reader = new Thread(new Reader(sharedData));
        Thread printer = new Thread(new Printer(sharedData));

        reader.start();
        printer.start();
    }
}
