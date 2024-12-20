package com.education.ztu;

import org.junit.*;
import org.mockito.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.util.*;

public class Lab8MockitoTest {

    @Mock
    private Lab8.Product mockProduct;

    @Captor
    private ArgumentCaptor<String> captor;

    @InjectMocks
    private List<Lab8.Product> productList = new ArrayList<>();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productList.add(new Lab8.Product("Laptop", "Dell", 1200, 5));
    }

    @Test
    public void testMockProduct() {
        when(mockProduct.getName()).thenReturn("MockPhone");
        assertEquals("MockPhone", mockProduct.getName());
        verify(mockProduct, times(1)).getName();
    }

    @Test
    public void testSpyProductList() {
        List<Lab8.Product> spyList = spy(productList);
        spyList.add(new Lab8.Product("Monitor", "Samsung", 400, 7));
        verify(spyList, times(1)).add(any(Lab8.Product.class));
        assertEquals(2, spyList.size());
    }
}
