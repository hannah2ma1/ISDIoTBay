package com.example.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.dao.OrderDAO;
import com.example.model.Order;

@WebServlet("/order")
public class OrderController extends HttpServlet {
    private OrderDAO orderDAO;

    public void init() {
        orderDAO = new OrderDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "add";
        }
        switch (action) {
            case "add":
                addOrder(request, response);
                break;
            // Add more cases for other actions like update, delete
            default:
                response.sendRedirect("order.jsp");
                break;
        }
    }

    private void addOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        Date orderDate = new Date();
        String status = "Pending";

        Order newOrder = new Order();
        newOrder.setUserId(userId);
        newOrder.setOrderDate(orderDate);
        newOrder.setStatus(status);

        orderDAO.addOrder(newOrder);
        response.sendRedirect("order.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                listOrders(request, response);
                break;
            // Add more cases for other actions like getOrder, delete
            default:
                response.sendRedirect("order.jsp");
                break;
        }
    }

    private void listOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Order> orders = orderDAO.getAllOrders();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("order.jsp").forward(request, response);
    }
}
