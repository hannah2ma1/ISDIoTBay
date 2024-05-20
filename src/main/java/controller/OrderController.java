package controller;

import model.Order;
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

@WebServlet("/order")
public class OrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            listOrders(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            createOrder(request, response);
        } else if ("update".equals(action)) {
            updateOrder(request, response);
        } else if ("cancel".equals(action)) {
            cancelOrder(request, response);
        }
    }

    private void listOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orders")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("userId"));
                order.setDeviceId(rs.getInt("deviceId"));
                order.setQuantity(rs.getInt("quantity"));
                order.setStatus(rs.getString("status"));
                orders.add(order);
            }
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("orderList.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int deviceId = Integer.parseInt(request.getParameter("deviceId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO orders (userId, deviceId, quantity, status) VALUES (?, ?, ?, 'pending')")) {
            stmt.setInt(1, userId);
            stmt.setInt(2, deviceId);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();

            response.sendRedirect("order?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE orders SET quantity = ? WHERE id = ?")) {
            stmt.setInt(1, quantity);
            stmt.setInt(2, id);
            stmt.executeUpdate();

            response.sendRedirect("order?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cancelOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE orders SET status = 'cancelled' WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            response.sendRedirect("order?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
