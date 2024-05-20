<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shipments</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Shipments</h2>
        <form action="shipment" method="post">
            <input type="hidden" name="action" value="add">
            <label for="orderId">Order ID:</label>
            <input type="number" id="orderId" name="orderId" required>
            <label for="shipmentMethod">Shipment Method:</label>
            <input type="text" id="shipmentMethod" name="shipmentMethod" required>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
            <button type="submit">Add Shipment</button>
        </form>
    </div>
</body>
</html>
