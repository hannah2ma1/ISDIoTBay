package com.example.model;

import java.sql.Date;

public class Order {
    private int id;
    private int userId;
    private int deviceId;
    private int quantity;
    private String status;

    public Order(int int1, int int2, Date date, String string) {
        //TODO Auto-generated constructor stub
    }

    public Order() {
        //TODO Auto-generated constructor stub
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public java.util.Date getOrderDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderDate'");
    }

    public void setOrderDate(java.util.Date orderDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOrderDate'");
    }
}
