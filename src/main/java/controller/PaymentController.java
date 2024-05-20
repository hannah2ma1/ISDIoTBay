package controller;

import model.Payment;
import util.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/payment")
public class PaymentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            listPayments(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            createPayment(request, response);
        } else if ("update".equals(action)) {
            updatePayment(request, response);
        } else if ("delete".equals(action)) {
            deletePayment(request, response);
        }
    }

    private void listPayments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> payments = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM payments")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getInt("id"));
                payment.setOrderId(rs.getInt("orderId"));
                payment.setMethod(rs.getString("method"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setDate(rs.getString("date"));
                payments.add(payment);
            }
            request.setAttribute("payments", payments);
            request.getRequestDispatcher("paymentList.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String method = request.getParameter("method");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String date = request.getParameter("date");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO payments (orderId, method, amount, date) VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1, orderId);
            stmt.setString(2, method);
            stmt.setDouble(3, amount);
            stmt.setString(4, date);
            stmt.executeUpdate();

            response.sendRedirect("payment?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updatePayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String method = request.getParameter("method");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String date = request.getParameter("date");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE payments SET method = ?, amount = ?, date = ? WHERE id = ?")) {
            stmt.setString(1, method);
            stmt.setDouble(2, amount);
            stmt.setString(3, date);
            stmt.setInt(4, id);
            stmt.executeUpdate();

            response.sendRedirect("payment?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deletePayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM payments WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            response.sendRedirect("payment?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
