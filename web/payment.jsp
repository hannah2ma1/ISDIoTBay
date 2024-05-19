<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Management - IoTBay</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <div class="container">
            <h1>IoTBay</h1>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="register.jsp">Register</a></li>
                    <li><a href="deviceCatalogue.jsp">Device Catalogue</a></li>
                    <li><a href="order.jsp">Orders</a></li>
                    <li><a href="payment.jsp">Payments</a></li>
                    <li><a href="shipment.jsp">Shipments</a></li>
                    <li><a href="customerInfo.jsp">Customer Info</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="container">
        <h2>Payment Management</h2>
        <form action="controller?action=createPayment" method="post">
            <label for="order">Order:</label>
            <select id="order" name="order">
                <!-- Populate order options here -->
                <option value="1">Example Order</option>
            </select>
            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" required>
            <label for="paymentMethod">Payment Method:</label>
            <select id="paymentMethod" name="paymentMethod">
                <option value="creditCard">Credit Card</option>
                <option value="paypal">PayPal</option>
            </select>
            <button type="submit">Make Payment</button>
        </form>
    </div>
    <footer>
        <p>IoTBay &copy; 2024</p>
    </footer>
</body>
</html>
