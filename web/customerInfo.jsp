<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Information - IoTBay</title>
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
        <h2>Customer Information</h2>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Type</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>
                <!-- Populate customer list here -->
                <tr>
                    <td>John Doe</td>
                    <td>john.doe@example.com</td>
                    <td>Individual</td>
                    <td>123 Main St</td>
                </tr>
            </tbody>
        </table>
    </div>
    <footer>
        <p>IoTBay &copy; 2024</p>
    </footer>
</body>
</html>
