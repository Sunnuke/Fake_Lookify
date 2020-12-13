<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Song</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row align-items-start">
		<div class="col"><h2>New Song:</h2></div>
			<div class="col">
				<a href="/dashboard">Dashboard</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h3>Title:</h3>
				<h3>Artist:</h3>
				<h3>Rating (1 - 10):</h3>
			</div>
			<div class="col">
				<form:form action="/dashboard" method="post" modelAttribute="song">
					<form:input path="title" placeholder="Title of Song"/><br>
					<br><form:input path="artist" placeholder="Artist of Song"/><br>
					<br><form:input type="number" path="rating" placeholder="Rating"/><br>
					<br><form:button type="submit">Add Song</form:button><br>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>