<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shipment Management - IoTBay</title>
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
        <h2>Shipment Management</h2>
        <form action="controller?action=createShipment" method="post">
            <label for="order">Order:</label>
            <select id="order" name="order">
                <!-- Populate order options here -->
                <option value="1">Example Order</option>
            </select>
            <label for="shipmentMethod">Shipment Method:</label>
            <select id="shipmentMethod" name="shipmentMethod">
                <option value="standard">Standard</option>
                <option value="express">Express</option>
            </select>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
            <button type="submit">Create Shipment</button>
        </form>
    </div>
    <footer>
        <p>IoTBay &copy; 2024</p>
    </footer>
</body>
</html>