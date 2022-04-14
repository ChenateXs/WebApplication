<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
    <div class="position-absolute top-50 start-50 translate-middle">
    <c:url value="/application/login" var="urllogin"></c:url>
	<form action="${urllogin}" method="post">
        <div style="text-align: center;">
            <h2>Login</h2>
            <div class="m-1">
                <label>Username:</label>
                <input type="text" class="username" name="username"/><br>
            </div>
            <div class="m-1">
                <label>Password:</label>
                <input type="password" class="password" name="password"/><br>
            </div>
            <input type="submit" value="Login">
        </div>
    </form>
    </div>
</body>
</html>