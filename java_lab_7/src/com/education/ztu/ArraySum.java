package com.education.ztu;

import java.util.Random;
import java.util.concurrent.*;

public class ArraySum {
    private static final int ARRAY_SIZE = 1_000_000;
    private static final int THREAD_COUNT = 5;
    private static final int[] numbers = new int[ARRAY_SIZE];

    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers[i] = random.nextInt(100);
        }


        long startTime = System.currentTimeMillis();
        int singleThreadSum = calculateSumSingleThread();
        long endTime = System.currentTimeMillis();
        System.out.println("Однопотокова сума: " + singleThreadSum);
        System.out.println("Час виконання (однопотоковий): " + (endTime - startTime) + " мс");


        startTime = System.currentTimeMillis();
        int multiThreadSum = calculateSumMultiThread();
        endTime = System.currentTimeMillis();
        System.out.println("Багатопотокова сума: " + multiThreadSum);
        System.out.println("Час виконання (багатопотоковий): " + (endTime - startTime) + " мс");
    }


    private static int calculateSumSingleThread() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }


    private static int calculateSumMultiThread() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        int chunkSize = ARRAY_SIZE / THREAD_COUNT;
        Future<Integer>[] futures = new Future[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            final int start = i * chunkSize;
            final int end = (i == THREAD_COUNT - 1) ? ARRAY_SIZE : start + chunkSize;
            futures[i] = executor.submit(() -> calculatePartialSum(start, end));
        }

        int totalSum = 0;


        try {
            for (Future<Integer> future : futures) {
                totalSum += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        return totalSum;
    }


    private static int calculatePartialSum(int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
