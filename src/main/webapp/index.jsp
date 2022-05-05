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
<body style="background-image: url('https://images.hdqwalls.com/download/dark-abstract-black-minimal-4k-q0-1920x1080.jpg');">

    <div class="position-absolute top-50 start-50 translate-middle border border-white rounded-3 text-white bg-dark w-25 h-25">
    <c:url value="login" var="urllogin"></c:url>
	<form action="${urllogin}" method="post">
        <div class="d-flex justify-content-center m-5" style="text-align: center;">
            <table>
            	<tr>
            		<td colspan="2"><h2>Login</h2></td>
            	</tr>
            	
            	<tr>
            		<td><label>Username:</label></td>
            		<td ><input type="text" class="username" name="username"/></td>
            	</tr>
            	<tr>
            		<td><label>Password:</label></td>
            		<td><input type="password" class="password" name="password"/><br></td>
            	</tr>
            	<tr>
            		<td colspan="2"><input class="btn btn-outline-light" type="submit" value="Login"></td>
            	</tr>
            	<tr>
            		<td colspan="2" class="m-1 text-danger"><label>${error_message}</label></td>
            	</tr>
            </table>
        </div>
    </form>
    </div>
</body>
</html>