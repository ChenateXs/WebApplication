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
    <title>Engineering</title>
</head>
<jsp:include page="/WEB-INF/pages/header.jsp"></jsp:include>
<body style="background-image: url('https://images.hdqwalls.com/download/dark-abstract-black-minimal-4k-q0-1920x1080.jpg');">
    <div class="position-absolute top-50 start-50 translate-middle">
    <c:url value="/application/add_manufacturer" var="urlAddManufacturer"></c:url>
	<form action="${urlAddManufacturer}" method="post">
        <div style="text-align: center;">
            <h2>Add Manufacturer</h2>
            <table>
            	<tr>
            		<td><label>Manufactortr Id:</label></td>
            		<td><input type="number" class="manufactortr_id" name="manufactortr_id"/><br></td>
            	</tr>
            	<tr>
            		<td><label>Tax Id:</label></td>
            		<td><input type="number" class="tax_id" name="tax_id"/><br></td>
            	</tr>
            	<tr>
            		<td><label>Address:</label></td>
            		<td><input type="text" class="address" name="address"/></td>
            	</tr>
            	<tr>
            		<td><label>City:</label></td>
            		<td>
            			<select class="form-select" aria-label="Default select example" name="city">
  							<c:forEach items="${cities}" var="c">
  								<option value="${c.zipCode}" name="city">${c.zipCode} ${c.name}</option>
  							</c:forEach>
  						</select>
  					</td>
            	</tr>
            	<tr>
            		<td colspan="2"><input type="submit" value="Create"></td>
            	</tr>
            </table>
            <div class="m-1 text-danger">
                <label>${error_message}</label>
            </div>
        </div>
    </form>
    </div>
</body>
</html>