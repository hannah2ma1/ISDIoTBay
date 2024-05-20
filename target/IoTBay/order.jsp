<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Orders</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Orders</h2>
        <form action="order" method="post">
            <input type="hidden" name="action" value="create">
            <label for="deviceId">Device ID:</label>
            <input type="number" id="deviceId" name="deviceId" required>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required>
            <button type="submit">Place Order</button>
        </form>
    </div>
</body>
</html>
