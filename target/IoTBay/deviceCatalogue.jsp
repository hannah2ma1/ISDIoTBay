<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Device Catalogue</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <h2>Device Catalogue</h2>
        <c:if test="${not empty devices}">
            <table>
                <thead>
                    <tr>
                        <th>Device Name</th>
                        <th>Type</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="device" items="${devices}">
                        <tr>
                            <td>${device.name}</td>
                            <td>${device.type}</td>
                            <td>${device.unitPrice}</td>
                            <td>${device.quantity}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>
