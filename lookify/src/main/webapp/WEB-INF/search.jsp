<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Artist Seach</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row align-items-start">
			<div class="col">
				<h2>Songs by artist: <c:out value="${search}"/></h2>
			</div>
			<div class="col">
				<form:form action="" method="post" modelAttribute="search">
					<form:input type="text" path="name"/>
					<form:button type="submit">New Search</form:button>
				</form:form>
			</div>
			<div class="col justify-content-end">
				<a href="/dashboard">Dashboard</a>
			</div>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td><a href="/songs/${song.title}"><c:out value="${song.title}"/></a></td>
						<td><c:out value="${song.rating}"/></td>
						<td><a href="/songs/${song.id}/delete">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>