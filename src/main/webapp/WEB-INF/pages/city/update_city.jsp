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
    <c:url value="/application/update_city" var="urlUpdateCity"></c:url>
	<form action="${urlUpdateCity}" method="post">
        <div style="text-align: center;" class="m-5">
            <h3>Update</h3>
            <table>
            	<tr>
            		<td><label>zipCode:</label></td>
            		<td><input type="number" value="${zipCode}" name="zipCode" readonly="readonly"/><br></td>
            	</tr>
            	<tr>
            		<td><label>Name:</label></td>
            		<td><input type="text" value="${name}" name="name"/><br></td>
            	</tr>
            	<tr>
            		<td colspan="2">
            			<input type="submit" name="confirm" value="Confirm" class="btn btn-outline-light"/>
            			<input type="submit" name="confirm" value="Cancel" class="btn btn-outline-light"/>
            		</td>
            	</tr>
            </table>
        </div>
    </form>
    </div>
</body>
</html>