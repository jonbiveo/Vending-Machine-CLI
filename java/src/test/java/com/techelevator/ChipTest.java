package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChipTest {
    @Test
    public void testChip() {
        Product product = new Chip("A2", "Stackers", new BigDecimal("4.50"), "Chip", 5);

        String locationActual = product.getSlotLocation();
        String locationExpected = "A2";

        String nameActual = product.getName();
        String nameExpected = "Stackers";

        BigDecimal priceActual = product.getPrice();
        BigDecimal priceExpected = new BigDecimal("4.50");

        String categoryActual = product.getCategory();
        String categoryExpected = "Chip";

        int quantityActual = product.getQuantity();
        int quantityExpected = 5;

        assertEquals(locationExpected, locationActual);
        assertEquals(nameExpected, nameActual);
        assertEquals(priceExpected, priceActual);
        assertEquals(categoryExpected, categoryActual);
        assertEquals(quantityExpected, quantityActual);
    }
}