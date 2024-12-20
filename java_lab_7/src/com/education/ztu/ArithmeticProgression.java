package com.education.ztu;

class ArithmeticProgression implements Runnable {
    private static int result = 1;

    public synchronized void printProgression() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(result + " ");
            result += 1;
            try {
                Thread.sleep(200); // чекаємо 0.2 секунди
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void run() {
        printProgression();
    }

    public static void main(String[] args) {
        ArithmeticProgression task = new ArithmeticProgression();

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
