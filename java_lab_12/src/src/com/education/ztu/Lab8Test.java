package com.education.ztu;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.rules.*;
import java.util.*;
import java.util.stream.*;

public class Lab8Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Lab8.Product product;

    @BeforeClass
    public static void setupBeforeClass() {
        System.out.println("Тести починаються...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Тести завершилися.");
    }

    @Before
    public void setup() {
        product = new Lab8.Product("Phone", "Apple", 999, 10);
    }

    @After
    public void tearDown() {
        product = null;
    }

    @Test
    public void testProductCreation() {
        assertNotNull("Об'єкт продукту не повинен бути null", product);
        assertEquals("Phone", product.getName());
        assertEquals("Apple", product.getBrand());
    }

    @Test
    public void testMultiplyNumbersFunction() {
        String input = "2 3 4";
        int result = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);
        assertEquals(24, result);
    }

    @Test
    public void testOptionalMaxNumber() {
        Integer max = Arrays.asList(1, 2, 3, 4, 5).stream()
                .max(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Числа відсутні"));
        assertEquals(Integer.valueOf(5), max);
    }


    @Test
    public void testStreamGrouping() {
        List<Lab8.Product> products = Arrays.asList(
                new Lab8.Product("Phone", "Apple", 999, 10),
                new Lab8.Product("Laptop", "Dell", 1200, 5)
        );
        Map<String, List<Lab8.Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Lab8.Product::getBrand));
        assertTrue(grouped.containsKey("Apple"));
        assertTrue(grouped.containsKey("Dell"));
    }

    @Test(expected = RuntimeException.class)
    public void testOptionalException() {
        List<Integer> emptyList = Collections.emptyList();
        emptyList.stream().max(Integer::compare).orElseThrow(() -> new RuntimeException("Числа відсутні"));
    }
}
