package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Product{

    public Chip(String slotLocation, String name, BigDecimal price, String category, int quantity) {
        super(slotLocation, name, price, category, quantity);
    }
}
