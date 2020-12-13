<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify's Top 10 Songs</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="container overflow-hidden">
		<div class="row">
			<div class="col"><h2>Top Ten Songs:</h2></div>
			<div class="col justify-content-end"><a href="/dashboard">Dashboard</a></div>
		</div>
  		<div class="row gy-5">
    		<div class="col-6">
      			<div class="p-3 border bg-light">
      				<c:forEach items="${songs}" var="song">
      					<p>${song.rating} - <a href="/songs/${song.id}">${song.title}</a> - ${song.artist}</p>
      				</c:forEach>
      			</div>
      		</div>
      	</div>
    </div>
</body>
</html>