package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.model.Device;
import util.DBConnection;

public class DeviceDAO {
    public void addDevice(Device device) {
        String sql = "INSERT INTO Devices (name, type, unitPrice, quantity) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, device.getName());
            stmt.setString(2, device.getType());
            stmt.setDouble(3, device.getUnitPrice());
            stmt.setInt(4, device.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Device getDeviceById(int id) {
        String sql = "SELECT * FROM Devices WHERE id = ?";
        Device device = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                device = new Device(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getDouble("unitPrice"),
                    rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return device;
    }

    public List<Device> getAllDevices() {
        List<Device> devices = new ArrayList<>();
        String sql = "SELECT * FROM Devices";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Device device = new Device(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getDouble("unitPrice"),
                    rs.getInt("quantity")
                );
                devices.add(device);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return devices;
    }
}
