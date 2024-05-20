package com.example.controller;

import java.io.IOException;
import java.util.List; // Correct import for List
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.dao.CustomerDAO;
import com.example.model.Customer;

@WebServlet("/customer")
public class CustomerController extends HttpServlet {
    private CustomerDAO customerDAO;

    public void init() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "add";
        }
        switch (action) {
            case "add":
                addCustomer(request, response);
                break;
            // Add more cases for other actions like update, delete
            default:
                response.sendRedirect("customerInfo.jsp");
                break;
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        String address = request.getParameter("address");

        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setEmail(email);
        newCustomer.setType(type);
        newCustomer.setAddress(address);

        customerDAO.addCustomer(newCustomer);
        response.sendRedirect("customerInfo.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                listCustomers(request, response);
                break;
            // Add more cases for other actions like getCustomer, delete
            default:
                response.sendRedirect("customerInfo.jsp");
                break;
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Customer> customers = customerDAO.getAllCustomers();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("customerInfo.jsp").forward(request, response);
    }
}
