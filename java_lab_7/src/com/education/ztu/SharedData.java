package com.education.ztu;

import java.util.Scanner;

class SharedData {
    private String message;
    private boolean hasMessage = false;

    public synchronized void writeMessage(String message) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.message = message;
        hasMessage = true;
        notify();
    }

    public synchronized String readMessage() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasMessage = false;
        notify();
        return message;
    }
}

class Reader implements Runnable {
    private final SharedData sharedData;

    public Reader(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введіть повідомлення: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                sharedData.writeMessage("Кінець програми");
                break;
            }
            sharedData.writeMessage(input);
        }
        scanner.close();
    }
}

class Printer implements Runnable {
    private final SharedData sharedData;

    public Printer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            String message = sharedData.readMessage();
            if (message.equals("Кінець програми")) {
                System.out.println("Printer завершує роботу.");
                break;
            }
            System.out.println("Printer отримав: " + message);
        }
    }
}