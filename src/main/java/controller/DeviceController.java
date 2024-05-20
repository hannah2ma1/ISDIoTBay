package controller;

import model.Device;
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

@WebServlet("/device")
public class DeviceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            listDevices(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            createDevice(request, response);
        } else if ("update".equals(action)) {
            updateDevice(request, response);
        } else if ("delete".equals(action)) {
            deleteDevice(request, response);
        }
    }

    private void listDevices(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Device> devices = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM devices")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Device device = new Device();
                device.setId(rs.getInt("id"));
                device.setName(rs.getString("name"));
                device.setType(rs.getString("type"));
                device.setPrice(rs.getDouble("price"));
                device.setQuantity(rs.getInt("quantity"));
                devices.add(device);
            }
            request.setAttribute("devices", devices);
            request.getRequestDispatcher("deviceList.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createDevice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO devices (name, type, price, quantity) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setString(2, type);
            stmt.setDouble(3, price);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();

            response.sendRedirect("device?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateDevice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE devices SET name = ?, type = ?, price = ?, quantity = ? WHERE id = ?")) {
            stmt.setString(1, name);
            stmt.setString(2, type);
            stmt.setDouble(3, price);
            stmt.setInt(4, quantity);
            stmt.setInt(5, id);
            stmt.executeUpdate();

            response.sendRedirect("device?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteDevice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM devices WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();

            response.sendRedirect("device?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
