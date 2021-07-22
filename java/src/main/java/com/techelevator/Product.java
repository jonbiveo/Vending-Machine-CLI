package com.techelevator;

public class Product {

    private String slotLocation;
    private String name;
    private double price;
    private String category;
    private int quantity;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String slotLocation, String name, double price, String category, int quantity) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;

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

