<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.example.model.Device" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Device Catalogue - IoTBay</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Device Catalogue</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Type</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            <%
                List<Device> devices = (List<Device>) request.getAttribute("devices");
                for (Device device : devices) {
            %>
            <tr>
                <td><%= device.getId() %></td>
                <td><%= device.getName() %></td>
                <td><%= device.getType() %></td>
                <td><%= device.getPrice() %></td>
                <td><%= device.getQuantity() %></td>
            </tr>
            <% } %>
        </table>
        <form action="device" method="post">
            <h3>Create New Device</h3>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br>
            <label for="type">Type:</label>
            <input type="text" id="type" name="type" required><br>
            <label for="price">Price:</label>
            <input type="number" step="0.01" id="price" name="price" required><br>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required><br>
            <input type="hidden" name="action" value="create">
            <input type="submit" value="Create Device">
        </form>
    </div>
</body>
</html>
