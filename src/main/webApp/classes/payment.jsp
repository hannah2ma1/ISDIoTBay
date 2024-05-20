<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.example.model.Payment" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payments - IoTBay</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Payments</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Order ID</th>
                <th>Method</th>
                <th>Amount</th>
                <th>Date</th>
            </tr>
            <%
                List<Payment> payments = (List<Payment>) request.getAttribute("payments");
                for (Payment payment : payments) {
            %>
            <tr>
                <td><%= payment.getId() %></td>
                <td><%= payment.getOrderId() %></td>
                <td><%= payment.getMethod() %></td>
                <td><%= payment.getAmount() %></td>
                <td><%= payment.getDate() %></td>
            </tr>
            <% } %>
        </table>
        <form action="payment" method="post">
            <h3>Create New Payment</h3>
            <label for="orderId">Order ID:</label>
            <input type="number" id="orderId" name="orderId" required><br>
            <label for="method">Method:</label>
            <input type="text" id="method" name="method" required><br>
            <label for="amount">Amount:</label>
            <input type="number" step="0.01" id="amount" name="amount" required><br>
            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required><br>
            <input type="hidden" name="action" value="create">
            <input type="submit" value="Create Payment">
        </form>
    </div>
</body>
</html>
