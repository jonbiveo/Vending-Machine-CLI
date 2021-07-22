package com.techelevator;

public class Product {

    private String slotLocation;
    private String name;
    private double price;
    private String category;

    public Product(String slotLocation, String name, double price, String category) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
