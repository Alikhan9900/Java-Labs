package com.education.ztu;

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Я люблю програмувати!!!");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread("InitialThread");
        System.out.println("Статус потоку: NEW");


        myThread.start();
        System.out.println("Ім'я: " + myThread.getName());
        System.out.println("Пріоритет: " + myThread.getPriority());
        System.out.println("Чи живий: " + myThread.isAlive());
        System.out.println("Чи активний: " + myThread.isDaemon());
        System.out.println("Статус потоку: RUNNING");


        myThread.setName("UpdatedThread");
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Оновлене ім'я: " + myThread.getName());
        System.out.println("Оновлений пріоритет: " + myThread.getPriority());


        myThread.join();
        System.out.println("Статус потоку: TERMINATED");


        Thread mainThread = Thread.currentThread();
        System.out.println("Ім'я головного потоку: " + mainThread.getName());
        System.out.println("Пріоритет головного потоку: " + mainThread.getPriority());
    }
}
