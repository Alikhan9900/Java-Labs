package com.education.ztu;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        class Product {
            private String name;
            private double price;

            public Product(String name, double price) {
                this.name = name;
                this.price = price;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            @Override
            public String toString() {
                return "Product{name='" + name + '\'' + ", price=" + price + '}';
            }
        }

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Apple", 1.0));
        productList.add(new Product("Banana", 0.5));
        productList.add(new Product("Cherry", 2.0));

        productList.addAll(Arrays.asList(
                new Product("Date", 1.5),
                new Product("Elderberry", 3.0)
        ));

        System.out.println("Products in list:");
        productList.forEach(System.out::println);

        System.out.println("Product at index 2: " + productList.get(2));
        System.out.println("Index of Banana: " + productList.indexOf(new Product("Banana", 0.5)));
        System.out.println("List size: " + productList.size());

        productList.remove(0);
        System.out.println("After removal:");
        productList.forEach(System.out::println);

        productList.set(1, new Product("Blueberry", 2.5));
        System.out.println("After setting new value:");
        productList.forEach(System.out::println);

        Collections.sort(productList, Comparator.comparing(Product::getName));
        System.out.println("Sorted products:");
        productList.forEach(System.out::println);

        ArrayDeque<Product> productQueue = new ArrayDeque<>();
        productQueue.push(new Product("Fig", 2.0));
        productQueue.offerLast(new Product("Grapes", 3.5));

        System.out.println("First product in queue: " + productQueue.getFirst());
        System.out.println("Last product in queue: " + productQueue.peekLast());

        productQueue.pop();
        System.out.println("After pop: " + productQueue);


        TreeSet<Product> productSet = new TreeSet<>(Comparator.comparing(Product::getName));
        productSet.add(new Product("Honeydew", 3.0));
        productSet.add(new Product("Kiwi", 1.2));

        System.out.println("First product in set: " + productSet.first());
        System.out.println("Last product in set: " + productSet.last());

        Map<String, Product> productMap = new HashMap<>();
        productMap.put("Lemon", new Product("Lemon", 0.8));
        productMap.put("Mango", new Product("Mango", 1.5));

        productMap.putIfAbsent("Lime", new Product("Lime", 0.9));
        System.out.println("All keys: " + productMap.keySet());
        System.out.println("All values: " + productMap.values());

        System.out.println("EntrySet example:");
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        List<Product> productsForCollections = Arrays.asList(
                new Product("Orange", 1.0),
                new Product("Peach", 1.8),
                new Product("Quince", 2.2)
        );

        Collections.sort(productsForCollections, Comparator.comparing(Product::getPrice));
        System.out.println("Sorted by price: " + productsForCollections);

        int index = Collections.binarySearch(productsForCollections, new Product("Peach", 1.8), Comparator.comparing(Product::getPrice));
        System.out.println("Index of Peach: " + index);

        Collections.reverse(productsForCollections);
        System.out.println("Reversed list: " + productsForCollections);

        Collections.shuffle(productsForCollections);
        System.out.println("Shuffled list: " + productsForCollections);

        Product filler = new Product("Default", 0.0);
        Collections.fill(productsForCollections, filler);
        System.out.println("Filled list: " + productsForCollections);

        Product maxProduct = Collections.max(productsForCollections, Comparator.comparing(Product::getPrice));
        System.out.println("Max product by price: " + maxProduct);

        Product minProduct = Collections.min(productsForCollections, Comparator.comparing(Product::getPrice));
        System.out.println("Min product by price: " + minProduct);

    }
}
