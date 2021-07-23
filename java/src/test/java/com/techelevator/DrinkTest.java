package com.techelevator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DrinkTest {

    @Test
    public void testDrink() {
        Product product = new Drink("C3", "Mountain Melter", new BigDecimal("3.50"), "Drink", 5);

        String locationActual = product.getSlotLocation();
        String locationExpected = "C3";

        String nameActual = product.getName();
        String nameExpected = "Mountain Melter";

        BigDecimal priceActual = product.getPrice();
        BigDecimal priceExpected = new BigDecimal("3.50");

        String categoryActual = product.getCategory();
        String categoryExpected = "Drink";

        int quantityActual = product.getQuantity();
        int quantityExpected = 5;

        assertEquals(locationExpected, locationActual);
        assertEquals(nameExpected, nameActual);
        assertEquals(priceExpected, priceActual);
        assertEquals(categoryExpected, categoryActual);
        assertEquals(quantityExpected, quantityActual);
    }

}