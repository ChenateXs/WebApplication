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
  <div class="w-75 p-3" style="margin: 0 auto">
 		<table class="w-100 table table-light table-striped">
    		<thead>
        		<tr class="table-dark">
            		<th scope="col">Zip code</th>
                	<th scope="col">Name</th>
                	<th scope="col"></th>
                	<th scope="col"></th>
            	</tr>
     		</thead>
        	<tbody>
				<c:forEach items="${cities}" var="c">
					<tr class="table-dark">
						<td>${c.zipCode}</td>
      					<td>${c.name}</td>
						<td><input type="submit" class="btn btn-outline-light" value="Update"/></td>
						<td><input type="submit" class="btn btn-outline-light" value="Delete"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>