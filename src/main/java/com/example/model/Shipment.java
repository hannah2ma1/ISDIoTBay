package com.example.model;

import java.sql.Date;

public class Shipment {
    private int id;
    private int orderId;
    private String method;
    private String date;
    private String address;

    public Shipment(int int1, int int2, String string, Date date2, String string2) {
        //TODO Auto-generated constructor stub
    }

    public Shipment() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShipmentMethod() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getShipmentMethod'");
    }

    public java.util.Date getShipmentDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getShipmentDate'");
    }

    public void setShipmentDate(java.util.Date shipmentDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setShipmentDate'");
    }

    public void setShipmentMethod(String shipmentMethod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setShipmentMethod'");
    }
}
