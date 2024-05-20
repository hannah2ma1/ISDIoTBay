package com.example.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List; // Correct import for List
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.dao.PaymentDAO;
import com.example.model.Payment;

@WebServlet("/payment")
public class PaymentController extends HttpServlet {
    private PaymentDAO paymentDAO;

    public void init() {
        paymentDAO = new PaymentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "add";
        }
        switch (action) {
            case "add":
                addPayment(request, response);
                break;
            // Add more cases for other actions like update, delete
            default:
                response.sendRedirect("payment.jsp");
                break;
        }
    }

    private void addPayment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String paymentMethod = request.getParameter("paymentMethod");
        double amount = Double.parseDouble(request.getParameter("amount"));
        Date paymentDate = new Date();

        Payment newPayment = new Payment();
        newPayment.setOrderId(orderId);
        newPayment.setPaymentMethod(paymentMethod);
        newPayment.setAmount(amount);
        newPayment.setPaymentDate(paymentDate);

        paymentDAO.addPayment(newPayment);
        response.sendRedirect("payment.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                listPayments(request, response);
                break;
            // Add more cases for other actions like getPayment, delete
            default:
                response.sendRedirect("payment.jsp");
                break;
        }
    }

    private void listPayments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Payment> payments = paymentDAO.getAllPayments();
        request.setAttribute("payments", payments);
        request.getRequestDispatcher("payment.jsp").forward(request, response);
    }
}
