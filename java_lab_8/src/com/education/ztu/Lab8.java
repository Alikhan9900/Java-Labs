package com.education.ztu;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Lab8 {

   
    @FunctionalInterface
    interface Printable {
        void print();
    }

    public static void main(String[] args) {

        Printable printable = () -> System.out.println("Лямбда вираз для інтерфейсу Printable.");
        printable.print();


        Predicate<String> isNumeric = s -> {
            try {
                Double.parseDouble(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };
        System.out.println("123 is numeric: " + isNumeric.test("123"));


        Consumer<String> startLesson = s -> System.out.println("Пара почалася о 8:30: " + s);
        Consumer<String> endLesson = s -> System.out.println("Пара закінчилася о 9:50: " + s);
        startLesson.andThen(endLesson).accept("Java Programming");


        Supplier<String> upperCaseSupplier = () -> "Це речення у верхньому регістрі".toUpperCase();
        System.out.println(upperCaseSupplier.get());

        Function<String, Integer> multiplyNumbers = input -> {
            return Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .reduce(1, (a, b) -> a * b);
        };
        System.out.println("Добуток чисел: " + multiplyNumbers.apply("2 3 4"));


        List<Product> products = Arrays.asList(
                new Product("Phone", "Apple", 999, 10),
                new Product("Laptop", "Lenovo", 1200, 5),
                new Product("Headphones", "JBL", 300, 20),
                new Product("Monitor", "Samsung", 400, 7)
        );


        products.stream().map(Product::getBrand).distinct().forEach(System.out::println);


        products.stream().filter(p -> p.getPrice() < 1000).limit(2).forEach(System.out::println);


        int totalCount = products.stream().mapToInt(Product::getCount).sum();
        System.out.println("Сума всіх товарів: " + totalCount);


        Map<String, List<Product>> groupedByBrand = products.stream().collect(Collectors.groupingBy(Product::getBrand));
        System.out.println(groupedByBrand);


        List<Product> sortedByPrice = products.stream()
                .sorted(Comparator.comparingInt(Product::getPrice))
                .collect(Collectors.toList());
        System.out.println(sortedByPrice);


        products.stream().map(Product::getName).forEach(System.out::println);

        Integer maxNumber = Arrays.asList(1, 2, 3, 4, 5).stream().max(Integer::compare).orElseThrow(() -> new RuntimeException("Числа відсутні"));
        System.out.println("Максимальне число: " + maxNumber);
    }


    static class Product {
        private String name;
        private String brand;
        private int price;
        private int count;

        public Product(String name, String brand, int price, int count) {
            this.name = name;
            this.brand = brand;
            this.price = price;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public String getBrand() {
            return brand;
        }

        public int getPrice() {
            return price;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", brand='" + brand + '\'' +
                    ", price=" + price +
                    ", count=" + count +
                    '}';
        }
    }
}
