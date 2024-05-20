<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.example.model.Shipment" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shipments - IoTBay</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Shipments</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Order ID</th>
                <th>Method</th>
                <th>Date</th>
                <th>Address</th>
            </tr>
            <%
                List<Shipment> shipments = (List<Shipment>) request.getAttribute("shipments");
                for (Shipment shipment : shipments) {
            %>
            <tr>
                <td><%= shipment.getId() %></td>
                <td><%= shipment.getOrderId() %></td>
                <td><%= shipment.getMethod() %></td>
                <td><%= shipment.getDate() %></td>
                <td><%= shipment.getAddress() %></td>
            </tr>
            <% } %>
        </table>
        <form action="shipment" method="post">
            <h3>Create New Shipment</h3>
            <label for="orderId">Order ID:</label>
            <input type="number" id="orderId" name="orderId" required><br>
            <label for="method">Method:</label>
            <input type="text" id="method" name="method" required><br>
            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required><br>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required><br>
            <input type="hidden" name="action" value="create">
            <input type="submit" value="Create Shipment">
        </form>
    </div>
</body>
</html>
