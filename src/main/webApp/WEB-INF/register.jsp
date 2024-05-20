<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register - IoTBay</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Register</h2>
        <form action="user?action=register" method="post">
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" required><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br>
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" required><br>
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
