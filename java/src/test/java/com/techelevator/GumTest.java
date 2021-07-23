package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {

    @Test
    public void testGum() {
        Product product = new Gum("D1", "U-Chews", new BigDecimal("2.50"), "Gum", 5);

        String locationActual = product.getSlotLocation();
        String locationExpected = "D1";

        String nameActual = product.getName();
        String nameExpected = "U-Chews";

        BigDecimal priceActual = product.getPrice();
        BigDecimal priceExpected = new BigDecimal("2.50");

        String categoryActual = product.getCategory();
        String categoryExpected = "Gum";

        int quantityActual = product.getQuantity();
        int quantityExpected = 5;

        assertEquals(locationExpected, locationActual);
        assertEquals(nameExpected, nameActual);
        assertEquals(priceExpected, priceActual);
        assertEquals(categoryExpected, categoryActual);
        assertEquals(quantityExpected, quantityActual);
    }

}