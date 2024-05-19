<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register - IoTBay</title>
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
        <h2>Register</h2>
        <form action="controller?action=register" method="post">
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" required>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required>
            <button type="submit">Register</button>
        </form>
    </div>
    <footer>
        <p>IoTBay &copy; 2024</p>
    </footer>
</body>
</html>
