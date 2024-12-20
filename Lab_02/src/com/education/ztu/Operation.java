package com.education.ztu;

public class Operation {
    public static int addition(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static int subtraction(int... numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public static int multiplication(int... numbers) {
        int result = 1;
        for (int num : numbers) {
            result *= num;
        }
        return result;
    }

    public static double division(int a, int b) {
        return (double) a / b;
    }

    public static double average(int... numbers) {
        return (double) addition(numbers) / numbers.length;
    }

    public static int maximum(int... numbers) {
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static int minimum(int... numbers) {
        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            min = Math.min(min, num);
        }
        return min;
    }
}
