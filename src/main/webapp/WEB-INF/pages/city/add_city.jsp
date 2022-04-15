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
    <title>Engineeringy</title>
</head>
<jsp:include page="/WEB-INF/pages/header.jsp"></jsp:include>
<body>
    <div class="position-absolute top-50 start-50 translate-middle">
    <c:url value="/application/add_city" var="urlAddCity"></c:url>
	<form action="${urlAddCity}" method="post">
        <div style="text-align: center;">
            <h2>Add city</h2>
            <div class="m-1">
                <label>Zip Code:</label>
                <input type="number" class="zip_code" name="zip_code"/><br>
            </div>
            <div class="m-1">
                <label>Name:</label>
                <input type="text" class="name" name="name"/><br>
            </div>
            <div class="m-1 text-danger">
                <label>${error_message}</label>
            </div>
            <input type="submit" value="Create">
        </div>
    </form>
    </div>
</body>
</html>