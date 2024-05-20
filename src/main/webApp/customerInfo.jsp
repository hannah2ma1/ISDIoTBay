<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Info - IoTBay</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Customer Information Management</h2>
        <form action="customer" method="post">
            <h3>Create New Customer</h3>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>
            <label for="type">Type:</label>
            <input type="text" id="type" name="type" required><br>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required><br>
            <input type="hidden" name="action" value="create">
            <input type="submit" value="Create Customer">
        </form>
    </div>
</body>
</html>
