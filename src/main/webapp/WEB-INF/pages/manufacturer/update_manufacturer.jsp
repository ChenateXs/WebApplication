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
    <c:url value="/application/update_manufacturer" var="urlUpdateManufacturer">
		<c:param name="id" value="${manufacturer.id}"></c:param>
    </c:url>
	<form action="${urlUpdateManufacturer}" method="post">
        <div style="text-align: center;" class="m-3">
            <h3>Update</h3>
            <table>
            	<tr>
            		<td><label>Manufacturer id:</label></td>
            		<td><input type="number" value="${manufacturer.manufactortrId}" name="manufacturerId" readonly="readonly"/><br></td>
            	</tr>
            	<tr>
            		<td><label>Tax id:</label></td>
            		<td><input type="number" value="${manufacturer.taxId}" name="taxId" readonly="readonly"/><br></td>
            	</tr>
            	<tr>
            		<td><label>Address:</label></td>
            		<td><input type="text" value="${manufacturer.address}" name="address"/><br></td>
            	</tr>
            	<tr>
            		<td><label>City:</label></td>
            		<td>
            			<select class="form-select" aria-label="Default select example" name="city">
  							<c:forEach items="${cities}" var="c">
  								<option value="${c.zipCode}" name="city" selected="${manufacturer.city.zipCode}">${c.zipCode} ${c.name}</option>
  							</c:forEach>
  						</select>
  					</td>
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