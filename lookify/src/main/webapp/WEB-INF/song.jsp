<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Selected Song: <c:out value="${song.title}"/></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row justify-content-end">
			<div class="col">
				<h2>Selected Song: </h2>
			</div>
			<div class="col">
				<a href="/dashboard">Dashboard</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<h3>Title:</h3>
				<h3>Artist:</h3>
				<h3>Rating (1 - 10):</h3>
				<h3><a href="/songs/${song.id}/delete">Delete</a></h3>
			</div>
			<div class="col">
				<h3><c:out value="${song.title}"/></h3>
				<h3><c:out value="${song.artist}"/></h3>
				<h3><c:out value="${song.rating}"/></h3>
			</div>
		</div>
	</div>
</body>
</html>