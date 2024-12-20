package com.education.ztu;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            if (i % 10 == 0) {
                System.out.println(i);
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Розрахунок завершено!!!");
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(2000);

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
    }
}
