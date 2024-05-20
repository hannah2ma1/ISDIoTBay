package controller;

import model.Shipment;
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

@WebServlet("/shipment")
public class ShipmentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            listShipments(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            createShipment(request, response);
        } else if ("update".equals(action)) {
            updateShipment(request, response);
        } else if ("delete".equals(action)) {
            deleteShipment(request, response);
        }
    }

    private void listShipments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Shipment> shipments = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM shipments")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Shipment shipment = new Shipment();
                shipment.setId(rs.getInt("id"));
                shipment.setOrderId(rs.getInt("orderId"));
                shipment.setMethod(rs.getString("method"));
                shipment.setDate(rs.getString("date"));
                shipment.setAddress(rs.getString("address"));
                shipments.add(shipment);
            }
            request.setAttribute("shipments", shipments);
            request.getRequestDispatcher("shipmentList.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createShipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String method = request.getParameter("method");
        String date = request.getParameter("date");
        String address = request.getParameter("address");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO shipments (orderId, method, date, address) VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1, orderId);
            stmt.setString(2, method);
            stmt.setString(3, date);
            stmt.setString(4, address);
            stmt.executeUpdate();

            response.sendRedirect("shipment?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateShipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String method = request.getParameter("method");
        String date = request.getParameter("date");
        String address = request.getParameter("address");

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE shipments SET method = ?, date = ?, address = ? WHERE id = ?")) {
            stmt.setString(1, method);
            stmt.setString(2, date);
            stmt.setString(3, address);
            stmt.setInt(4, id);
            stmt.executeUpdate();

            response.sendRedirect("shipment?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteShipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM shipments WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            response.sendRedirect("shipment?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
