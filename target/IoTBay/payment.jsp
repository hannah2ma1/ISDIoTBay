<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payments</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Payments</h2>
        <form action="payment" method="post">
            <input type="hidden" name="action" value="add">
            <label for="orderId">Order ID:</label>
            <input type="number" id="orderId" name="orderId" required>
            <label for="paymentMethod">Payment Method:</label>
            <input type="text" id="paymentMethod" name="paymentMethod" required>
            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" step="0.01" required>
            <button type="submit">Add Payment</button>
        </form>
    </div>
</body>
</html>
