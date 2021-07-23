package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CandyTest {

    @Test
    public void testCandy() {
        Product product = new Candy("A1", "Wonka Bar", new BigDecimal("1.50"), "Candy", 5);

        String locationActual = product.getSlotLocation();
        String locationExpected = "A1";

        String nameActual = product.getName();
        String nameExpected = "Wonka Bar";

        BigDecimal priceActual = product.getPrice();
        BigDecimal priceExpected = new BigDecimal("1.50");

        String categoryActual = product.getCategory();
        String categoryExpected = "Candy";

        int quantityActual = product.getQuantity();
        int quantityExpected = 5;

        assertEquals(locationExpected, locationActual);
        assertEquals(nameExpected, nameActual);
        assertEquals(priceExpected, priceActual);
        assertEquals(categoryExpected, categoryActual);
        assertEquals(quantityExpected, quantityActual);

    }

}