<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
</head>
<body>
<<<<<<< HEAD
	<h3>Category List</h3>
	<div class="container">
		
=======
	<jsp:include page="admin_display.jsp"></jsp:include>

	<div class="container">
		<a href="/restaurant_billing_system/addcategory">Create New</a>
		<div class="row">
			
            <div class="col">Name</div>
			
		</div>
		<c:forEach var="menuItemType" items="${menuItemTypes}">
			<div class="row">
			
			<div class="col">${menuItemType.type}</div>
			
			<div class="col">
				<a href="editcategory/${menuItemType.id}">Edit</a>|
				<a href="deletecategory/${menuItemType.id}">Delete</a>
			</div>
		</div>
		</c:forEach>
>>>>>>> 878a5c01d26f80538c417256bc899f78d848e8ef
	</div>
</body>
</html>