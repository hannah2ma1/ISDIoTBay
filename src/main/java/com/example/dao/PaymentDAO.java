package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.model.Payment;
import util.DBConnection;

public class PaymentDAO {
    public void addPayment(Payment payment) {
        String sql = "INSERT INTO Payments (orderId, paymentMethod, amount, paymentDate) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, payment.getOrderId());
            stmt.setString(2, payment.getPaymentMethod());
            stmt.setDouble(3, payment.getAmount());
            stmt.setDate(4, new java.sql.Date(payment.getPaymentDate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Payment getPaymentById(int id) {
        String sql = "SELECT * FROM Payments WHERE id = ?";
        Payment payment = null;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                payment = new Payment(
                    rs.getInt("id"),
                    rs.getInt("orderId"),
                    rs.getString("paymentMethod"),
                    rs.getDouble("amount"),
                    rs.getDate("paymentDate")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payments";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Payment payment = new Payment(
                    rs.getInt("id"),
                    rs.getInt("orderId"),
                    rs.getString("paymentMethod"),
                    rs.getDouble("amount"),
                    rs.getDate("paymentDate")
                );
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
}
