package com.example.model;

import java.sql.Date;

public class Payment {
    private int id;
    private int orderId;
    private String method;
    private double amount;
    private String date;

    public Payment(int int1, int int2, String string, double double1, Date date2) {
        //TODO Auto-generated constructor stub
    }

    public Payment() {
        //TODO Auto-generated constructor stub
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentMethod'");
    }

    public java.util.Date getPaymentDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentDate'");
    }

    public void setPaymentMethod(String paymentMethod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPaymentMethod'");
    }

    public void setPaymentDate(java.util.Date paymentDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPaymentDate'");
    }
}
