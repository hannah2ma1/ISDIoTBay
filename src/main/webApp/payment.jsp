<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>IoTBay - Payments</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Payments</h2>
        <table>
            <thead>
                <tr>
                    <th>Payment ID</th>
                    <th>Order ID</th>
                    <th>Payment Method</th>
                    <th>Amount</th>
                    <th>Payment Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="payment" items="${payments}">
                    <tr>
                        <td>${payment.id}</td>
                        <td>${payment.orderId}</td>
                        <td>${payment.paymentMethod}</td>
                        <td>${payment.amount}</td>
                        <td>${payment.paymentDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
