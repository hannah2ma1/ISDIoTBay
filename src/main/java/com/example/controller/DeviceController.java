package com.example.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.DeviceDAO;
import com.example.model.Device;

import java.io.IOException;
import java.util.List;

@WebServlet("/device")
public class DeviceController extends HttpServlet {
    private DeviceDAO deviceDAO;

    public void init() {
        deviceDAO = new DeviceDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "add";
        }
        switch (action) {
            case "add":
                addDevice(request, response);
                break;
            // Add more cases for other actions like update, delete
            default:
                response.sendRedirect("deviceCatalogue.jsp");
                break;
        }
    }

    private void addDevice(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Device newDevice = new Device();
        newDevice.setName(name);
        newDevice.setType(type);
        newDevice.setUnitPrice(unitPrice);
        newDevice.setQuantity(quantity);

        deviceDAO.addDevice(newDevice);
        response.sendRedirect("deviceCatalogue.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                listDevices(request, response);
                break;
            // Add more cases for other actions like getDevice, delete
            default:
                response.sendRedirect("deviceCatalogue.jsp");
                break;
        }
    }

    private void listDevices(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Device> devices = deviceDAO.getAllDevices();
        request.setAttribute("devices", devices);
        request.getRequestDispatcher("deviceCatalogue.jsp").forward(request, response);
    }
}
