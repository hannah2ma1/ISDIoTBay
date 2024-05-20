<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.example.model.Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Orders - IoTBay</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Orders</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>User ID</th>
                <th>Device ID</th>
                <th>Quantity</th>
                <th>Status</th>
            </tr>
            <%
                List<Order> orders = (List<Order>) request.getAttribute("orders");
                for (Order order : orders) {
            %>
            <tr>
                <td><%= order.getId() %></td>
                <td><%= order.getUserId() %></td>
                <td><%= order.getDeviceId() %></td>
                <td><%= order.getQuantity() %></td>
                <td><%= order.getStatus() %></td>
            </tr>
            <% } %>
        </table>
        <form action="order" method="post">
            <h3>Create New Order</h3>
            <label for="userId">User ID:</label>
            <input type="number" id="userId" name="userId" required><br>
            <label for="deviceId">Device ID:</label>
            <input type="number" id="deviceId" name="deviceId" required><br>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required><br>
            <input type="hidden" name="action" value="create">
            <input type="submit" value="Create Order">
        </form>
    </div>
</body>
</html>
