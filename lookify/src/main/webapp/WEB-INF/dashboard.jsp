<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify: Dashboard</title>
</head>
<body>
	<div class="container">
		<div class="row align-items-start">
			<div class="col">
			<a href="/songs/new">Add New</a>
			</div>
			<div class="col">
			<a href="/search/topTen">Top Songs</a>
			</div>
			<div class="col">
				<form:form action="" method="post" modelAttribute="search">
					<form:input type="text" path="name"/>
					<form:button type="submit">Search</form:button>
				</form:form>
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
						<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
						<td><c:out value="${song.rating}"/></td>
						<td><a href="/songs/${song.id}/delete">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>