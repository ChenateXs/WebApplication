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
<body style="background-image: url('https://images.hdqwalls.com/download/dark-abstract-black-minimal-4k-q0-1920x1080.jpg');">
    <div class="position-absolute top-50 start-50 translate-middle border border-white rounded-3 text-white bg-dark">
    <c:url value="/application/delete_manufacturer" var="urlDeleteManufacturer">
    	<c:param name="id" value="${manufacturtr.id}"></c:param>
    </c:url>
	<form action="${urlDeleteManufacturer}" method="post">
        <div style="text-align: center;" class="m-5">
            <h3>Are you sure you want to delete manufacturer with id: ${manufacturtr.manufactortrId}</h3>
            <input type="submit" name="confirm" value="Yes" class="btn btn-outline-light"/>
            <input type="submit" name="confirm" value="No" class="btn btn-outline-light"/>
        </div>
    </form>
    </div>
</body>
</html>