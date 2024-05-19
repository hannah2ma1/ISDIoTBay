<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Management - IoTBay</title>
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
        <h2>Order Management</h2>
        <form action="controller?action=createOrder" method="post">
            <label for="device">Device:</label>
            <select id="device" name="device">
                <!-- Populate device options here -->
                <option value="1">Example Device</option>
            </select>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required>
            <button type="submit">Place Order</button>
        </form>
    </div>
    <footer>
        <p>IoTBay &copy; 2024</p>
    </footer>
</body>
</html>
