package com.example.model;

public class Device {
    private int id;
    private String name;
    private String type;
    private double price;
    private int quantity;

    public Device(int int1, String string, String string2, double double1, int int2) {
        //TODO Auto-generated constructor stub
    }

    public Device() {
        //TODO Auto-generated constructor stub
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUnitPrice'");
    }

    public void setUnitPrice(double unitPrice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUnitPrice'");
    }
}