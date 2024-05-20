package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.model.Shipment;
import util.DBConnection;

public class ShipmentDAO {
    public void addShipment(Shipment shipment) {
        String sql = "INSERT INTO Shipments (orderId, shipmentMethod, shipmentDate, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, shipment.getOrderId());
            stmt.setString(2, shipment.getShipmentMethod());
            stmt.setDate(3, new java.sql.Date(shipment.getShipmentDate().getTime()));
            stmt.setString(4, shipment.getAddress());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Shipment getShipmentById(int id) {
        String sql = "SELECT * FROM Shipments WHERE id = ?";
        Shipment shipment = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                shipment = new Shipment(
                    rs.getInt("id"),
                    rs.getInt("orderId"),
                    rs.getString("shipmentMethod"),
                    rs.getDate("shipmentDate"),
                    rs.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shipment;
    }

    public List<Shipment> getAllShipments() {
        List<Shipment> shipments = new ArrayList<>();
        String sql = "SELECT * FROM Shipments";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Shipment shipment = new Shipment(
                    rs.getInt("id"),
                    rs.getInt("orderId"),
                    rs.getString("shipmentMethod"),
                    rs.getDate("shipmentDate"),
                    rs.getString("address")
                );
                shipments.add(shipment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shipments;
    }
}
