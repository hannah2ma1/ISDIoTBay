package com.example.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List; // Correct import for List
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.dao.ShipmentDAO;
import com.example.model.Shipment;

@WebServlet("/shipment")
public class ShipmentController extends HttpServlet {
    private ShipmentDAO shipmentDAO;

    public void init() {
        shipmentDAO = new ShipmentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "add";
        }
        switch (action) {
            case "add":
                addShipment(request, response);
                break;
            // Add more cases for other actions like update, delete
            default:
                response.sendRedirect("shipment.jsp");
                break;
        }
    }

    private void addShipment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String shipmentMethod = request.getParameter("shipmentMethod");
        Date shipmentDate = new Date();
        String address = request.getParameter("address");

        Shipment newShipment = new Shipment();
        newShipment.setOrderId(orderId);
        newShipment.setShipmentMethod(shipmentMethod);
        newShipment.setShipmentDate(shipmentDate);
        newShipment.setAddress(address);

        shipmentDAO.addShipment(newShipment);
        response.sendRedirect("shipment.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                listShipments(request, response);
                break;
            // Add more cases for other actions like getShipment, delete
            default:
                response.sendRedirect("shipment.jsp");
                break;
        }
    }

    private void listShipments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Shipment> shipments = shipmentDAO.getAllShipments();
        request.setAttribute("shipments", shipments);
        request.getRequestDispatcher("shipment.jsp").forward(request, response);
    }
}
